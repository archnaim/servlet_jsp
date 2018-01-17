package com.javabootcamp.dto;

public class Cart {
	private int id;
	private User user;
	private Product product;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Cart(int id, User user, Product product, int amount) {
		this.id = id;
		this.user = user;
		this.product = product;
		this.amount = amount;
	}
	public Cart(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", product=" + product + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
}
