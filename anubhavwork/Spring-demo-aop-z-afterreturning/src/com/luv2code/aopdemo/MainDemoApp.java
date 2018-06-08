package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.SecondAccoundDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//read the spring config java file
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the AccountDao bean from spring container
		
		SecondAccoundDao theaccount = context.getBean("secondAccoundDao", SecondAccoundDao.class);
		
	//call the business method
		
		List<Account> thesecond = theaccount.findAccounts();  
		
		System.out.println("TheMain demo Accounts are" +thesecond );
		
		// close the context
		context.close();   
		
	}

}
