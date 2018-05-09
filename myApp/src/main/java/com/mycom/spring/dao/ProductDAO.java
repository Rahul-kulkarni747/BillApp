package com.mycom.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mycom.spring.domain.Category;
import com.mycom.spring.domain.Product;

@Repository
@Transactional
public class ProductDAO extends AbstractORMDAO implements IProductDAO{

	@Override
	public void saveProduct(Product product) {
		saveOrupdate(product);
	}

	@Override
	public List<Product> fetchAllProducts() {
		return fetchAll(Product.class);
	}

	@Override
	public Category getCategoty(int categoryId) {
		return fetchById(categoryId, Category.class);
	}

	@Override
	public void saveCategory(Category category1) {
		saveOrupdate(category1);
	}

	@Override
	public List<Category> fetchCategories() {
		return fetchAll(Category.class);
	}

	@Override
	public List<Product> fetchProductsOfCategory(int id) {
		return fetchAllByKey("category", id, Product.class);
	}

}
