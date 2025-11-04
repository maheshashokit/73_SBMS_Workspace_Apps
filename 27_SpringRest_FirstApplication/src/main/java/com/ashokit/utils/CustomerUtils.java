package com.ashokit.utils;

import java.util.ArrayList;
import java.util.List;

import com.ashokit.dto.Customer;

public class CustomerUtils {

	public static List<Customer> getAllCustomers() {

		List<Customer> customerList = new ArrayList<Customer>();

		Customer cust1 = new Customer("AIT123", "Ashok", "Hyderabad");
		Customer cust2 = new Customer("AIT234", "Mahesh", "Bangalore");
		Customer cust3 = new Customer("AIT456", "Suresh", "Chennai");
		Customer cust4 = new Customer("AIT789", "Rajesh", "Hyderabad");
		Customer cust5 = new Customer("AIT987", "Nagesh", "Chennai");

		customerList.add(cust1);
		customerList.add(cust2);
		customerList.add(cust3);
		customerList.add(cust4);
		customerList.add(cust5);

		return customerList;
	}

}
