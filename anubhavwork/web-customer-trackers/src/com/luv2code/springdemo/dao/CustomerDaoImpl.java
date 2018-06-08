package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomer() {
	
		//Create query to retrive the table
		
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
		Query theQuery = currentSession.createQuery("from Customer");
		
		List<Customer> theCustomer = theQuery.getResultList();
		
		return theCustomer;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		//get the current Session
		
		Session theSession = sessionFactory.getCurrentSession();
		
		theSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getInfo(int theId) {
		// TODO Auto-generated method stub
		
		//get current Session
		Session theSession = sessionFactory.getCurrentSession();
		
		// get the customer from database
		Customer theCustomers = theSession.get(Customer.class, theId);
		
		return theCustomers;
	}

	@Override
	public void delete(int theid) {
		// TODO Auto-generated method stub
		
		//get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, theid);

		currentSession.delete(customer);

		}
		
	} 
		
	

