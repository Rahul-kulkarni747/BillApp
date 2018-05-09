package com.mycom.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(columnDefinition="TEXT")
	private String img;
	
	private float cost;
	private float tax;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	public Product() {
		super();
		String s;
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(String name, String img, float cost, float tax, String description, Category category) {
		super();
		this.name = name;
		this.img = img;
		this.cost = cost;
		this.tax = tax;
		this.description = description;
		this.category = category;
	}


	

	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
