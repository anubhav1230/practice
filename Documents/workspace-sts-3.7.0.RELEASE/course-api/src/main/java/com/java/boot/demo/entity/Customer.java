package com.java.boot.demo.entity;

public class Customer {
	
	
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	
	public Customer(){}
	
	
	public Customer(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
