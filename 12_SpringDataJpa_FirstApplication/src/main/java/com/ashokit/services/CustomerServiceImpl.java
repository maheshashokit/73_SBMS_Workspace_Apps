package com.ashokit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dao.CustomerDao;
import com.ashokit.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer creatingNewBrandCustomer(Customer customer) {
		Customer savedCustomerDetails = customerDao.save(customer);
		return savedCustomerDetails;
	}

	@Override
	public Iterable<Customer> createBulkNewBrandCustomers(List<Customer> customers) {
		Iterable<Customer> savedCustomerDetails = customerDao.saveAll(customers);
		return savedCustomerDetails;
	}

	@Override
	public Customer findCustomerById(Integer customerId) {
		Optional<Customer> customerDetails = customerDao.findById(customerId);
		//Checking Customer data is present in optional object or not.
		if(customerDetails.isPresent()) {
			//Extracting the customer object from optional object
			return customerDetails.get();
		}else {
			return null;
		}
	}

	@Override
	public Iterable<Customer> fetchAllCustomers() {
		Iterable<Customer> allCustomers = customerDao.findAll();
		return allCustomers;
	}

}
