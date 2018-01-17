package com.javabootcamp.dto;

public class User {
	private int id;
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String username, String password) {

		this.username = username;
		this.password = password;
	}
	
	public User(String username) {

		this.username = username;
//		this.password = password;
	}
	
	public User(int id, String username) {

		this.id = id;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
	

}
