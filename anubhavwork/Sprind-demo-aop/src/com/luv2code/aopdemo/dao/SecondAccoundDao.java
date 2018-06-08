package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class SecondAccoundDao {

	public boolean addAccount(){
		
		System.out.println(getClass() +  " : I am SecondAccountDao");
		return false;
		
	}
	
}
