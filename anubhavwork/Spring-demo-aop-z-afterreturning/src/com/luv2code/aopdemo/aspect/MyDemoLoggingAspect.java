package com.luv2code.aopdemo.aspect;

import java.util.List;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component

public class MyDemoLoggingAspect {

	//this is where we add all our related advices for logging
	
//let's start with @before advice
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.SecondAccoundDao.findAccounts(..))",
			returning="result")
	public void AfterReturningAccountAdvice(JoinPoint theJoin, List<Account> result){
		
	String method = theJoin.getSignature().toShortString();
	System.out.println("------> I m advice Printin the calling method" +method );
	
	System.out.println(" Advice Printing theresult" +result);
	
	// post process the data and modify it before 
	
	convertAccountNamesTOUpperCase(result);
	
	//new Result
	
	System.out.println("\n ------------------------>>> The new Names " + result);
	
	
	
	}

	private void convertAccountNamesTOUpperCase(List<Account> result) {
		
		for(Account tempAccount :result){
			
			//get uppercase version of name
			
			String UpperNAme=tempAccount.getName().toUpperCase();
			// set the Name
			
			tempAccount.setName(UpperNAme);
			
		}
		
	;
	}
}
