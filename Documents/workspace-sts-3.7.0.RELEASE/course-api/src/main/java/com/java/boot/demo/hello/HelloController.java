package com.java.boot.demo.hello;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.boot.demo.entity.Customer;

@RestController
@RequestMapping("/api")
public class HelloController {

	List<Customer> theCustomer;

	@PostConstruct
	public void loadData() {

	}

	@GetMapping("/hello")
	public String display() {
		System.out.println("hieee Spring boot!");

		return "hello";

	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		theCustomer = new ArrayList<Customer>();
		theCustomer.add(new Customer("anubhav", "arpit0905"));
		theCustomer.add(new Customer("Yash", "arpit0906"));

		return theCustomer;
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		getCustomers();
		return theCustomer.get(customerId);
	}

	// return theCustomer.get(id);

}
