package com.mycom.spring.config;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

 

@ControllerAdvice
public class StandardResponseBodyAdvice implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return (AnnotationUtils.findAnnotation(returnType.getContainingClass(), ResponseBody.class) != null || returnType.getMethodAnnotation(ResponseBody.class) != null);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		STDJSONResponse<Object> resp = new STDJSONResponse<Object>();		 
		resp.setPayload(body);
		return resp;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<STDJSONResponse> standardException(Exception exception){
		STDJSONResponse jsonResponse = new STDJSONResponse();
		String details = exception.toString();
		jsonResponse.addError("error", exception.getMessage());
		return new ResponseEntity<STDJSONResponse>(jsonResponse, HttpStatus.REQUEST_TIMEOUT);
	}
}