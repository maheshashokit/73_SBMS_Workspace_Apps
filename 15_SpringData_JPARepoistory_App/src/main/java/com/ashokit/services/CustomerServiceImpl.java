package com.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ashokit.dao.CustomerDao;
import com.ashokit.enities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer createNewBrandCustomerUsingSaveAndFlush(Customer customer) {
        
		//We are using JPARepoistory interface methods
		Customer savedCustomer = customerDao.saveAndFlush(customer);
		return savedCustomer;
	}

	@Override
	public void terminateCustomers(List<Integer> customerIds) {
		//We are using JPARepoistory interface methods
		 customerDao.deleteAllByIdInBatch(customerIds);
	}

	@Override
	public Customer fetchCustomerDetailsById(Integer customerId) {
		//We are using JPARepoistory interface methods
		//If supplied customerId is not present will throw an EntityNotFoundException 
		Customer customerDetails = customerDao.getReferenceById(customerId);
		return customerDetails;
	}

	@Override
	public void fetchAllCustomers(Customer customer) {
		
		//We are using JPARepoistory interface methods
	    List<Customer> allCustomers = customerDao.findAll(Example.of(customer),Sort.by(Direction.DESC,"customerName"));
	    
	    //processing the collection
	    allCustomers.forEach(System.out::println);
	}
}
