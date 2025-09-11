package com.ashokit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.enities.Customer;
import java.util.List;


public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	//List<Customer> findByCustomerLocation(String customerLocation);
	
	//List<Customer> findByCustomerName(String customerName);
	
	//List<Customer> findByCustomerNameIgnoreCase();
	
	//List<Customer> findByCustomerLocationAndCustomerName(String customerLocation,String customerName);

	
}
