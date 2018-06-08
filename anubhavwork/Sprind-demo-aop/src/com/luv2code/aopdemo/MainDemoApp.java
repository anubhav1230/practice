package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.SecondAccoundDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//read the spring config java file
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the AccountDao bean from spring container
		
		AccountDao theaccount = context.getBean("accountDao",AccountDao.class);
		
		//get the SecondAccountDao bean from the spring container
		
		SecondAccoundDao thesecond = context.getBean("secondAccoundDao",SecondAccoundDao.class);
		
		
		// call the business logic
		Account theAccount = new Account();
		
		theaccount.addAccount(theAccount,true);
		
		//call the business logic
		
		thesecond.addAccount();
		
		//call the method sleep
		
		theaccount.goSleep();
		
		// close the context
		context.close();   
		
	}

}
