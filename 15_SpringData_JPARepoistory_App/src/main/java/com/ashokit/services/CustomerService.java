package com.ashokit.services;
import java.util.List;

import com.ashokit.enities.Customer;

public interface CustomerService {

	// saving the new customer
	public Customer createNewBrandCustomerUsingSaveAndFlush(Customer customer);

	// Deleting all customers based on customerids
	public void terminateCustomers(List<Integer> customerIds);

	// Getting customerDetails based on customerId
	public Customer fetchCustomerDetailsById(Integer customerId);

	// Fetching All Customers information based on Example Object
	public void fetchAllCustomers(Customer customer);
	
}