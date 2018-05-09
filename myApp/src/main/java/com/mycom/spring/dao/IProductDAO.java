package com.mycom.spring.dao;

import java.util.List;

import com.mycom.spring.domain.Category;
import com.mycom.spring.domain.Product;

public interface IProductDAO {

	public void saveProduct(Product product);

	public List<Product> fetchAllProducts();

	public Category getCategoty(int categoryId);

	public void saveCategory(Category category1);

	public List<Category> fetchCategories();

	public List<Product> fetchProductsOfCategory(int categoryId);
}
