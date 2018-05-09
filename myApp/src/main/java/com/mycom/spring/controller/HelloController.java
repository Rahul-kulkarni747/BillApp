package com.mycom.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.spring.dto.CategoryDTO;
import com.mycom.spring.dto.ProductDTO;
import com.mycom.spring.service.IProductService;

@RestController
@CrossOrigin
public class HelloController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		return "welcome";
	}
	
	@PostMapping("/addProduct")
	public Map<String, String> saveProduct(@RequestBody ProductDTO product){
		Map<String, String> response= new HashMap<>();
		productService.saveProduct(product);
		response.put("resp", "Added");
		return response;
	}
	
	@GetMapping("/fetchProducts")
	public List<ProductDTO> fetchProducts(){
		List<ProductDTO> productDTOs = productService.fetchAllProducts();
		return productDTOs;
	}
	
	@PostMapping("/addCategoty")
	public String saveCategory(@RequestBody CategoryDTO category){
		productService.saveCategory(category);
		return "Added";
	}
	
	@GetMapping("/fetchCategory")
	public List<CategoryDTO> fetchCategories(){
		List<CategoryDTO> productDTOs = productService.fetchCategories();
		return productDTOs;
	}
	
	@GetMapping("/fetchProductsOfCategory")
	public List<ProductDTO> fetchProductsOfCategory(@RequestParam int categoryId){
		List<ProductDTO> productDTOs = productService.fetchProductsOfCategory(categoryId);
		return productDTOs;
	}
	
}
