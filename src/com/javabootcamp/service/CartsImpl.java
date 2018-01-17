package com.javabootcamp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javabootcamp.service.Carts;
import com.javabootcamp.dto.Cart;
import com.javabootcamp.dto.Product;
import com.javabootcamp.dto.User;

public class CartsImpl implements Carts{
	
	private Database db = new DatabaseImpl();

	
	private Product getProductHelper(ResultSet rs) throws SQLException
	{
		return new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("price"), rs.getString("type"));
	}
	
	private User getUserHelper(ResultSet rs) throws SQLException
	{
		return new User(rs.getString("username"));
	}
	
	private Cart getCartHelper(ResultSet rs) throws SQLException
	{
		return new Cart(rs.getInt("id"), getUserHelper(rs), getProductHelper(rs), rs.getInt("amount"));
	}
	
	@Override
	public List<Cart> findByUserId(Integer id)
	{
		List<Cart> result = new ArrayList<Cart>();
		
		try {
			db.init();
			Statement statement = db.statement();
			
			ResultSet rs = statement.executeQuery(""
					+ "SELECT c.id, u.username, c.product_id, p.name, p.type, p.price, c.amount "
					+ "FROM `cart` c, `user` u, `product` p "
					+ "WHERE c.user_id = "+id+" AND c.user_id = u.id AND c.product_id = p.id");
			while(rs.next())
			{
				result.add(getCartHelper(rs));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.close();
		}
		
		return result;
	}
	

	
	@Override
	public boolean save(Cart o) {
		try {
			db.init();
			Statement statement = db.statement();
			
			statement.executeUpdate("INSERT INTO `cart`(`user_id`, `product_id`, `amount`) VALUES ("
					+ o.getUser().getId()+","
					+ o.getProduct().getId()+","
					+ o.getAmount()+")");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.close();
		}
		
		return true;
	}

	@Override
	public boolean update(Cart o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cart o) {
		try {
			db.init();
			Statement statement = db.statement();
			
			statement.executeUpdate("DELETE FROM `cart` WHERE id = "+o.getId());
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.close();
		}
		
		return true;
	}

	@Override
	public Optional<Cart> find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
