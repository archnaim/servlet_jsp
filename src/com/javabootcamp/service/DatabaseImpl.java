	package com.javabootcamp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.javabootcamp.Constant;

public class DatabaseImpl implements Database{
	private Connection conn;
	
	
	@Override
	public void init() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName(Constant.JDBC_DRIVER).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.conn = DriverManager.getConnection(Constant.JDBC_URI,Constant.JDBC_USER,Constant.JDBC_PASS);
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Statement statement() throws SQLException {
		// TODO Auto-generated method stub
		return this.conn.createStatement();
	}

	@Override
	public void init(boolean autocommit) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName(Constant.JDBC_DRIVER).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.conn.setAutoCommit(autocommit);
		this.conn = DriverManager.getConnection(Constant.JDBC_URI,Constant.JDBC_USER,Constant.JDBC_PASS);
	}

}
