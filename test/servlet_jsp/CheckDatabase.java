package servlet_jsp;


import org.junit.jupiter.api.Test;

import com.javabootcamp.dto.Cart;
import com.javabootcamp.dto.Product;
import com.javabootcamp.dto.User;
import com.javabootcamp.service.Carts;
import com.javabootcamp.service.CartsImpl;
import com.javabootcamp.service.Goods;
import com.javabootcamp.service.GoodsImpl;

class CheckDatabase {
	
	Goods goods = new GoodsImpl();
	Carts carts = new CartsImpl();

	@Test
	void loadAll() {
		System.out.println(this.goods.findAll());
	}
	
	@Test
	void load1() {
		System.out.println(this.goods.find(1));
		System.out.println(this.goods.find(2));
	}
	
	@Test
	void loadCategories() {
		System.out.println(this.goods.findByCategories("fashion"));
	}
	
	
	
	

}
