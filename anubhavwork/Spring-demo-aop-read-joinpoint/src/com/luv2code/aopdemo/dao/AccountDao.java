package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount(Account theaccount, boolean flag){
		
		System.out.println(getClass() + "Doing my DB work of add account");
		
	}
	
	public void goSleep(){
		
		System.out.println(getClass() + "Go to sleep");
		
	}
	
}
