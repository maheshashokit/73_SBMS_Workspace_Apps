package com.ashokit.services;

import java.util.List;

import com.ashokit.entity.Customer;

public interface CustomerService {
	
	//creating new customer record
	public Customer creatingNewBrandCustomer(Customer customer);
	
	//creating bulk of new customers
	public Iterable<Customer> createBulkNewBrandCustomers(List<Customer> customers);
	
	//Finding the customer By CustomerId
	public Customer findCustomerById(Integer customerId);
	
	//Finding All Customers
	public Iterable<Customer> fetchAllCustomers();
}
