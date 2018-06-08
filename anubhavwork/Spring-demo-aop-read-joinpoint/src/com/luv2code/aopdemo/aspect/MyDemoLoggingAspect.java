package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	//this is where we add all our related advices for logging
	
//let's start with @before advice
	
	//logger
	private Logger mylogger = Logger.getLogger(getClass().getName());
	
@Pointcut("execution(* add*(com.luv2code.aopdemo.Account,.. ))")
public void forDaoPackage(){}
	
	
	//pointcut expression//logging advice 
	//monitoring the network
	//listners
@Before("forDaoPackage()") 
	public void beforaddAccountAdice(JoinPoint theJoinPoint){
		
		System.out.println("========> Execution @Before advice on account");
		
		Signature thesignature = theJoinPoint.getSignature();
		
		System.out.println("the signature is" + thesignature );
		
		Object arg[] = theJoinPoint.getArgs();
		
		for(Object temp : arg)
		{
			
			mylogger.info("The objects are " +temp);
			
		}
		
	}
	
	
	
}
