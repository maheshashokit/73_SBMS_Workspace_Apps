package com.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashokit.service.CustomerService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("1. Executing Stored Procedure with one input and one output....");
		customerService.getCustomerNameByCustomerId(103);
		
		System.out.println();
		System.out.println("2. Executing Stored Procedure with one input and output as Map Object....");
		customerService.getCustomerDetailsInfo(103);
		
		System.out.println();
		System.out.println("3. Executing Stored Procedure with one input and object as output....");
		customerService.getCustomerDetailsById(103);
		
		System.out.println();
		System.out.println("4. Executing Stored Procedure with object as output List Of Customers....");
		customerService.getAllCustomers();	
	}
}
