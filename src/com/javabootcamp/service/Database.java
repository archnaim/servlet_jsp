package com.javabootcamp.service;

import java.sql.SQLException;
import java.sql.Statement;

public interface Database {
	
	public void init() throws ClassNotFoundException, SQLException;
	
	public void init(boolean autocommit) throws ClassNotFoundException, SQLException;
	
	public void close();
	
	public Statement statement() throws SQLException;
	

}
