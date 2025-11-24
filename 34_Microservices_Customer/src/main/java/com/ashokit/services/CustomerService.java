package com.ashokit.services;

import java.util.List;

import com.ashokit.request.CustomerRequest;
import com.ashokit.response.ApiResponse;
import com.ashokit.response.CustomerResponse;

public interface CustomerService {
	
	public CustomerResponse createCustomer(CustomerRequest customerRequest);
	
	public ApiResponse getCustomerById(Integer customerId);
	
	public List<CustomerResponse> getAllCustomers();

}