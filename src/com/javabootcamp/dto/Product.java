package com.javabootcamp.dto;

public class Product {
	private int id;
	private String productName;
	private String price;
	private String type;
	
	public Product(int id, String productName, String price, String type) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", type=" + type + "]";
	}
}
