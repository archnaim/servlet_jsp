package com.javabootcamp.service;

import java.util.List;

import com.javabootcamp.dto.Product;

public interface Goods extends Dao<Product, Integer> {
	public List<String> findCategories();
	public List<Product> findByCategories(String categories);

}
