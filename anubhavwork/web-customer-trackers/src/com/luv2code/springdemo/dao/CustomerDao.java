package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDao {

	 public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getInfo(int theId);

	public void delete(int theid); 
	
	
}
