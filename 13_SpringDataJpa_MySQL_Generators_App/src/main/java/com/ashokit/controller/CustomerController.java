package com.ashokit.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ashokit.entity.Customer;
import com.ashokit.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public void createNewCustomer(Customer customer) {
		Customer customerDetails = customerService.creatingNewBrandCustomer(customer);
		if (Objects.nonNull(customerDetails)) {
			System.out.println("Customer Created SuccessFully.....");
			System.out.println(customerDetails);
		} else {
			System.out.println("Customer Not Created......");
		}
	}

	public void createBulkNewCustomers(List<Customer> customerList) {

		Iterable<Customer> savedCustomers = customerService.createBulkNewBrandCustomers(customerList);

		// forEach() from Java1.8 version which accepts Consumer FunctionaInterface as parameter
		// Consumer Functional Interface abstract method implementation we can provide through LambdaExpression
		// Consumer FI contains one abstract method i.e.,accept(T t)
		savedCustomers.forEach(eachCustomer -> System.out.println(eachCustomer));
	}
	
	public void fetchCustomerDetailsById(Integer customerId) {
		Customer customerDetails = customerService.findCustomerById(customerId);
	    System.out.println("CustomerDetails:::"+ customerDetails);
	}
	
	public void fetchAllCustomersDetails() {
		Iterable<Customer> customerDetails = customerService.fetchAllCustomers();
		//processing Java8 forEach loop
		customerDetails.forEach(eachCustomer -> System.out.println(eachCustomer));
	}

}
