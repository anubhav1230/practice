package com.luv2code.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService theService;

	@RequestMapping("/show")
	public String showPage(Model theModel){
		
		List<Customer> theCustomer = theService.getCustomer();
		System.out.println("The Customer" +theCustomer);
		
		theModel.addAttribute("customers", theCustomer);
		return "list-customers";
		
		
		
	}
	
	
	@RequestMapping("/addCustomer")
	public String showFormAdd(Model theModel){
		
		//Make a new object to bind to form data
		Customer theCustomer = new Customer(); 
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
	}
	
	@RequestMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		//save the customer in db
		theService.saveCustomer(theCustomer);
		
		return "redirect:/customer/show";
	}
	
	@RequestMapping("/showFormUpdate")
	public String updateCustomer(HttpServletRequest request, Model themodel ){
		
		String Id  = request.getParameter("customerId"); 
		
		int theId = Integer.parseInt(Id);
		
		Customer customer = theService.getInfo(theId);
		
		themodel.addAttribute("customer" ,customer);
		
		return "customer-form";
		
		
	}
	
	
@RequestMapping("/processDelete")
public String delete (@RequestParam("customerId") int theid){
	
	
	theService.delete(theid);
	
	return "redirect:/customer/show";
	
}
	
	
}
