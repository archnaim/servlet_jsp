package com.javabootcamp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javabootcamp.dto.Product;

public class GoodsImpl implements Goods{
	
	private Database db = new DatabaseImpl();
	private Statement statement;
	
	private Product getProductHelper(ResultSet rs) throws SQLException
	{
		return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price"), rs.getString("type"));
	}
	
	@Override
	public Optional<Product> find(Integer id) {
		
		
		try {
			this.db.init();
			this.statement = db.statement();
			
			ResultSet rs = this.statement.executeQuery("SELECT * FROM product where product.id = "+id);
			
			if(rs.next())
			{
				Optional<Product> result = Optional.of(getProductHelper(rs));
				this.db.close();
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.db.close();
		}
		
		return Optional.empty();
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> result = new ArrayList<Product>();
		
		try {
			this.db.init();
			this.statement = db.statement();
			
			ResultSet rs = this.statement.executeQuery("SELECT * FROM product");
			
			while(rs.next())
			{
				result.add(getProductHelper(rs));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.db.close();
		}
		return result;
	}

	@Override
	public boolean save(Product o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> findCategories() {
		// TODO Auto-generated method stub
		
		List<String> result = new ArrayList<String>();
		try {
			this.db.init();
			this.statement = db.statement();
			
			ResultSet rs = this.statement.executeQuery("SELECT DISTINCT(type) from product");
			
			while(rs.next())
			{
				result.add(rs.getString("type"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.db.close();
		}
		return result;
	}

	@Override
	public List<Product> findByCategories(String categories) {
		// TODO Auto-generated method stub
List<Product> result = new ArrayList<Product>();
		
		try {
			this.db.init();
			this.statement = db.statement();
			
			ResultSet rs = this.statement.executeQuery("SELECT * FROM product where type = '"+categories+"'");
			
			while(rs.next())
			{
				result.add(getProductHelper(rs));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.db.close();
		}
		return result;
	}

}
