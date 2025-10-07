package com.ashokit.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.ashokit.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	@Procedure(name = "fetchCustomerName")
	public String fetchCustomerNameById(Integer custId);
	
	@Procedure(name="customerInfoDetails")
    public Map<String,Object> fetchCustomerDetailsById(Integer custId);
	
	@Procedure(name="fetchCustomerDetails")
	public Customer fetchCustomerDetailsByCustomerId(Integer custId);
	
	@Procedure(name="fetchAllCustomerDetails")
	public List<Customer> getAllCustomers();
	
}