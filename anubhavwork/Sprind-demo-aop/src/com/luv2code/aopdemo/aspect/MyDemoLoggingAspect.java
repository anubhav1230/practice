package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class MyDemoLoggingAspect {

	//this is where we add all our related advices for logging
	
//let's start with @before advice
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
@Pointcut("execution(* add*(com.luv2code.aopdemo.Account,.. ))")
public void forDaoPackage(){}
	
	
	//pointcut expression//logging advice 
	//monitoring the network
	//listners
@Before("forDaoPackage()") 
	public void beforaddAccountAdice(){
		
		System.out.println("========> Execution @Before advice on account");
		myLogger.info("I m from myloggeer");
		
	}
	
	
	
}
