package com.ashokit;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashokit.dao.CustomerDao;
import com.ashokit.entity.Customer;
import com.ashokit.services.CustomerService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	public CustomerService customerService;
	
	@Autowired
	public CustomerDao customerDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
         //Creating the customers
	    //customerDao.saveAll(getCustomersData());
	    
	    System.out.println("1...... Finding the Customers Based on Name");
		customerService.fetchCustomersByName("Bhoopal");
		System.out.println();
		System.out.println("2...... Finding the Customers Based on Location");
		customerService.fetchCustomersByNameAndLocation("Mark", "Pune");
		System.out.println();
		System.out.println("3...... Finding the Customers Based on Location with pagination");
		//2 -- Records Per Page 
		//1 -- Page No 
		customerService.fetchCustomersByLocationWithPagination("Hyderabad1",2,2);
		System.out.println();
		System.out.println("4...... Finding the Customers Count Based On CustomerName");
		customerService.getCountOfCustomerName("Mahesh");
		System.out.println();
		System.out.println("5...... Finding the Customers Based On BillAmount");
		customerService.fetchCustomersBetweenBillAmount(1000,5000);
		System.out.println();
		System.out.println("6...... Finding the Customers Based On CustomerName using like condition");
		List<Customer> allCustomer = customerDao.findByNameContainingIgnoreCase("M");
		allCustomer.forEach(System.out::println);

	}

	public List<Customer> getCustomersData() {

		Customer customer1 = new Customer("Mahesh", "Hyderabad1", 25000);
		Customer customer2 = new Customer("Suresh", "Hyderabad2", 35000);
		Customer customer3 = new Customer("Rajesh", "Hyderabad3", 25000);
		Customer customer4 = new Customer("Ramesh", "Hyderabad4", 45000);
		Customer customer5 = new Customer("Nagesh", "Hyderabad4", 55000);
		Customer customer6 = new Customer("Yagnesh", "Hyderabad3", 65000);
		Customer customer7 = new Customer("Ganesh", "Hyderabad3", 6500);
		Customer customer8 = new Customer("Naresh", "Hyderabad2", 12000);
		Customer customer9 = new Customer("Rameshwar", "Hyderabad2", 9000);
		Customer customer10 = new Customer("Anil", "Hyderabad2", 2548);
		Customer customer11 = new Customer("Avinash", "Hyderabad1", 7895);
		Customer customer12 = new Customer("Smith", "Hyderabad1", 3215);
		Customer customer13 = new Customer("John", "Hyderabad1", 5462);
		Customer customer14 = new Customer("Mark", "Pune", 5000);
		Customer customer15 = new Customer("Bhoopal", "Pune", 2561);
		Customer customer16 = new Customer("Bhoopal", "Pune", 2561);
		Customer customer17 = new Customer("Mahesh", "Hyderabad1", 25000);

		// Java9 Style for Creating Immutable Collection
		List<Customer> customers = List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7,
				customer8, customer9, customer10, customer11, customer12, customer13, customer14, customer15,
				customer16,customer17);

		return customers;
	}

}
