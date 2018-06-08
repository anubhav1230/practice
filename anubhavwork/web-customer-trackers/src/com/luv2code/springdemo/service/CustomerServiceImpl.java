package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao theCustomerDao;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return theCustomerDao.getCustomer();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		theCustomerDao.saveCustomer(theCustomer);
	}


	@Override
	@Transactional
	public Customer getInfo(int theId) {
		// TODO Auto-generated method stub
		return theCustomerDao.getInfo(theId);
	}


	@Override
	@Transactional
	public void delete(int theid) {
		// TODO Auto-generated method stub
		
		theCustomerDao.delete(theid);
		
		
	}

}
