package com.javabootcamp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javabootcamp.dto.User;

public class AuthenticationImpl implements Authentication {

	private Database db = new DatabaseImpl();
	private Statement statement;
	
	@Override
	public Integer authorized(User user) {
		// TODO Auto-generated method stub
		String psw_db = "";
		int user_id = -1;
		
		try {
			this.db.init();
			this.statement = this.db.statement();
			ResultSet rs= this.statement.executeQuery("select id, password from user where username = '"+ user.getUsername()+"'");

			while(rs.next())
			{
				psw_db = rs.getString("password");
				user_id = rs.getInt("id");
			}
			
			this.db.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.print("auth method");
		if(user.getPassword().equals(psw_db))
		{
			return user_id;
		}
		else
		{
			return -1;
		}
	}

	

}
