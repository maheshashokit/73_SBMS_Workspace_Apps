package com.ashokit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashokit.dao.CustomerDao;
import com.ashokit.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public void getCustomerNameByCustomerId(int customerId) {
		String customerName = customerDao.fetchCustomerNameById(customerId);
		System.out.println("CustomerName ::::" + customerName);
	}
	
	@Transactional
	public void getCustomerDetailsInfo(int customerId) {
		Map<String,Object> customerDetails = customerDao.fetchCustomerDetailsById(customerId);
		System.out.println("CustomerDetails Info ::::" + customerDetails);
	}
	
	@Transactional
	public void getCustomerDetailsById(int customerId) {
		Customer customerDetails = customerDao.fetchCustomerDetailsByCustomerId(customerId);
		System.out.println("Customer Details:::::"+customerDetails);
	}
	
	@Transactional
	public void getAllCustomers() {
		List<Customer> customerDetails = customerDao.getAllCustomers();
		customerDetails.stream().forEach(cust -> System.out.println(cust));
	}		
}