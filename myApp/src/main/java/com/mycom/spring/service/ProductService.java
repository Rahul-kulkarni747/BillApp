package com.mycom.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.spring.dao.IProductDAO;
import com.mycom.spring.domain.Category;
import com.mycom.spring.domain.Product;
import com.mycom.spring.dto.CategoryDTO;
import com.mycom.spring.dto.ProductDTO;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;
	
	@Override
	public ProductDTO saveProduct(ProductDTO dto) {
		Category category=productDAO.getCategoty(dto.getCategory());
		Product product=new Product(dto.getName(), dto.getImage(), dto.getPrice(), dto.getTax(),dto.getDesc(),category);
		productDAO.saveProduct(product);
		return dto;
	}

	@Override
	public List<ProductDTO> fetchAllProducts() {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<Product> products=productDAO.fetchAllProducts();
		
		for (Product product : products) {
			ProductDTO dto=new ProductDTO();
			dto.setDesc(product.getDescription());
			dto.setImage(product.getImg());
			dto.setName(product.getName());
			dto.setPrice(product.getCost());
			dto.setTax(product.getTax());
			productDTOs.add(dto);
		}
		
		return productDTOs;
	}

	@Override
	public void saveCategory(CategoryDTO category) {
		Category category1=new Category(category.getName());
		productDAO.saveCategory(category1);
	}

	@Override
	public List<CategoryDTO> fetchCategories() {
		List<CategoryDTO> categoryDTOs=new ArrayList<>();
		List<Category> categories=productDAO.fetchCategories();
		
		for (Category category : categories) {
			CategoryDTO categoryDTO=new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getCategoryName());
			categoryDTOs.add(categoryDTO);
		}
		
		return categoryDTOs;
	}

	@Override
	public List<ProductDTO> fetchProductsOfCategory(int categoryId) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<Product> products=productDAO.fetchProductsOfCategory(categoryId);
		
		for (Product product : products) {
			ProductDTO dto=new ProductDTO();
			dto.setDesc(product.getDescription());
			dto.setImage(product.getImg());
			dto.setName(product.getName());
			dto.setPrice(product.getCost());
			dto.setTax(product.getTax());
			productDTOs.add(dto);
		}
		
		return productDTOs;
	}

}
