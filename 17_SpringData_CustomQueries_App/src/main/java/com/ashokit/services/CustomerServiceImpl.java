package com.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dao.CustomerDao;
import com.ashokit.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void fetchCustomerDetailsUsingNativeQuery() {
		List<Customer> allCustomers = customerDao.getAllCustomersByNativeQuery();
		allCustomers.forEach(System.out::println);
	}

	@Override
	public void fetchCustomerDetailsUsingHqlQuery() {
        List<Customer> allCustomers = customerDao.getAllCustomers();
        allCustomers.forEach(System.out::println);
	}

	@Override
	public void fetchSelectedColumnsUsingNativeQuery() {
		 List<Object[]> allCustomers = customerDao.getAllCustomersInfo();
		 allCustomers.forEach(eachObject -> {
			 System.out.println(eachObject[0] + " ---" + eachObject[1]);
		 });
		 
		 /*for(Object[] obj: allCustomers) {
			 System.out.println(obj[0]+"===="+obj[1]);
		 }*/
	}

	@Override
	public void fetchSelectedColumnsUsingHqlQuery() {
		 List<Object[]> allCustomers = customerDao.getAllCustomersDetails();
		 allCustomers.forEach(eachObject -> {
			 System.out.println(eachObject[0] + " ---" + eachObject[1]);
		 });
	}
	
	@Override
	public void fetchCustomerDetailsByCity(String location){
		List<Customer> allCustomers = customerDao.getAllCustomersByCity(location);
		allCustomers.forEach(System.out::println);
	}
	
	@Override
	public void fetchCustomerDetailsByLocation(String location,float billAmount){
		List<Customer> allCustomers = customerDao.getAllCustomersByLocation(location, billAmount);
		allCustomers.forEach(System.out::println);
	}

}
