package com.luv2code.aopdemo.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class SecondAccoundDao {

	public boolean addAccount(){
		
		System.out.println(getClass() +  " : I am SecondAccountDao");
		return false;
		
	}
	
	
	public  List<Account> findAccounts(){
		
		
		List<Account> theAccount = new ArrayList<Account>();
		
		//create sample accounts
		Account temp1 = new Account("Anubhav", "Silver");
		Account temp2 = new Account("yash", "platinum");
		Account temp3 = new Account("Anmol" , "Gold");
		
		//add into the list
		theAccount.add(temp1);
		theAccount.add(temp2);
		theAccount.add(temp3);
		
		return theAccount;
		
		
		
		
		
	}
	
	
}
