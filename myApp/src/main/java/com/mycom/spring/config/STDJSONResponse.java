
package com.mycom.spring.config;

import java.util.HashMap;
import java.util.Map;

public class STDJSONResponse<T> {

	private Header header = new Header();

	private Body body = new Body();
	
	public void setPayload(T payload){
		this.body.payload = payload;
	}
	
	public void addError(String errorId, String errorMessage){
		this.header.setErrorDetails(errorId,errorMessage); 
   }

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	private class Body {

		private T payload;

		public T getPayload() {
			return payload;
		}

		public void setPayload(T payload) {
			this.payload = payload;
		}

	}
	
	public class Header {
		
		private Boolean haserror = false;
		
		private int errorId;
		
		private String errorMessage;

		private Map<String, String> errorDetailsMap = new HashMap<String, String>();

	 
		public Boolean getHaserror() {
			return haserror;
		}

		 
		public void setHaserror(Boolean haserror) {
			this.haserror = haserror;
		}

		 
		public int getErrorId() {
			return errorId;
		}

		 
		public void setErrorId(int i) {
			this.errorId = i;
		}
	 
		public String getErrorMessage() {
			return errorMessage;
		}

		/**
		 * @param errorMessage the errorMessage to set
		 */
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		/**
		 * @return the errorDetailsMap
		 */
		public Map<String, String> getErrorDetailsMap() {
			return errorDetailsMap;
		}

		/**
		 * @param errorDetailsMap the errorDetailsMap to set
		 */
		public void setErrorDetailsMap(Map<String, String> errorDetailsMap) {
			this.errorDetailsMap = errorDetailsMap;
		}

		public void setErrorDetails(String errorId , String errorMessage) {
			this.haserror = true;
			this.errorMessage = errorMessage;
			this.errorDetailsMap.put(errorId,errorMessage);
		}
		
	}
	
}
