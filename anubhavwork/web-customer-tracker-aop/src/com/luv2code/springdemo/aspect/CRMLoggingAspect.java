package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//get logger
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//setup pointcut decleration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage(){}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage(){}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage(){}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")// we are checking for controller or service or dao Package
	public void AppWorkflow(){}
	//Add @Before advice
	@Before("AppWorkflow()")
	public void before (JoinPoint theJoin){
		
		//displaying  method  we are calling
		
		String theMethod = theJoin.getSignature().toShortString();//display the short method name
		
		logger.info("\n ======> in @Before calling method" +theMethod);
		
		//get the argument to methods
		Object[] args = theJoin.getArgs();
		
		//loop them
		
		
		
		for(Object temp : args){
			
			
			logger.info("\n ======> arguments are :" +temp);
		}
		
		
	}
	
	
	
	//Add @AfterReturn advice
	@AfterReturning(
			pointcut="AppWorkflow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
	logger.info("=====>> in @AfterReturning: from method: " + theMethod);
				
		// display data returned
		logger.info("=====>> result: " + theResult);
	
	}
	
	
}
