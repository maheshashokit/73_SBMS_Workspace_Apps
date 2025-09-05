package com.ashokit;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashokit.dao.CustomerDao;
import com.ashokit.enities.Customer;
import com.ashokit.services.CustomerService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerDao customerDao;	
	
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//saveAll the Customers Information
		//customerService.saveAllCustomers(getCustomersData());
		
		//PageSize=6, PageNo=0, TotalRecords=15, No of Pages=3(0 to 2), 
		List<Customer> customers = customerService.getCustomerInfo(0, 6);
		
		//Displaying the page of customers information
		customers.forEach(eachCustomer -> System.out.println(eachCustomer));
		
		//customerService.getCustomerInfo();
		
		//customerName --- Entity Class FieldName
		//customerService.getAllCustomerInSortingOrder("asc", "customerName","customerLocation");
		
		//customerService.getCustomerInfo();
	}
	
	
	public List<Customer> getCustomersData(){
		
		Customer customer1 = new Customer("Mahesh","Hyderabad1");
		Customer customer2 = new Customer("Suresh","Hyderabad2");
		Customer customer3 = new Customer("Rajesh","Hyderabad3");
		Customer customer4 = new Customer("Ramesh","Hyderabad4");
		Customer customer5 = new Customer("Nagesh","Hyderabad5");
		Customer customer6 = new Customer("Yagnesh","Hyderabad6");
		Customer customer7 = new Customer("Ganesh","Hyderabad7");
		Customer customer8 = new Customer("Naresh","Hyderabad8");
		Customer customer9 = new Customer("Rameshwar","Hyderabad1");
		Customer customer10 = new Customer("Anil","Hyderabad10");
		Customer customer11 = new Customer("Avinash","Hyderabad11");
		Customer customer12 = new Customer("Smith","Hyderabad12");
		Customer customer13 = new Customer("John","Hyderabad13");
		Customer customer14 = new Customer("Mark","Hyderabad14");
		Customer customer15 = new Customer("Bhoopal","Hyderabad15");
		
		//Java9 Style for Creating Immutable Collection
		List<Customer> customers = 
		List.of(customer1,customer2,customer3,customer4,customer5,
				customer6,customer7,customer8,customer9,customer10,
				customer11,customer12,customer13,customer14,customer15);
		

		return customers;
	}

}
