package com.mycom.spring.service;

import java.util.List;

import com.mycom.spring.dto.CategoryDTO;
import com.mycom.spring.dto.ProductDTO;

public interface IProductService {

	public ProductDTO saveProduct(ProductDTO dto);

	public List<ProductDTO> fetchAllProducts();

	public void saveCategory(CategoryDTO category);

	public List<CategoryDTO> fetchCategories();

	public List<ProductDTO> fetchProductsOfCategory(int categoryId);
}
