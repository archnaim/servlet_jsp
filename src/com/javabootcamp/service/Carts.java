package com.javabootcamp.service;

import java.util.List;

import com.javabootcamp.dto.Cart;

public interface Carts extends Dao<Cart,Integer>{
	
	List<Cart> findByUserId(Integer id);

}
