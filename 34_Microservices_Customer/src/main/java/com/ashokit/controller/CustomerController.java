package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.request.CustomerRequest;
import com.ashokit.response.ApiResponse;
import com.ashokit.response.CustomerResponse;
import com.ashokit.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/customers")
//@RefreshScope
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/welcome")
	public ResponseEntity<String> getWelcomeMessage(){
		log.debug("Inside the CustomerController - getWelcomeMessage().....");
		String message = null;
		message.length();
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	//Getting All the customers
	@GetMapping(value = "/")
	public ResponseEntity<?> fetchAllCustomers(){
		List<CustomerResponse> allCustomers = customerService.getAllCustomers();
		return ResponseEntity.ok(allCustomers);
	}
	
	//Getting particular customer
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<?> fetchCustomerDetailsById(@PathVariable("customerId") Integer customerId){
		//FirstTechnique -> Not Readable
		//CustomerResponse customerDetails = customerService.getCustomerById(customerId);
		
		//SecondTechnique -> Readability
		ApiResponse customerDetails = customerService.getCustomerById(customerId);
		
		return ResponseEntity.ok(customerDetails);
	}
	
	//creating the new customer
	@PostMapping(value = "/")
	public ResponseEntity<?> createNewCustomer(@RequestBody CustomerRequest customerRequest){
		log.debug("Inside the CustomerController - createNewCustomer()....."+customerRequest);
		CustomerResponse newCustomerDetails = customerService.createCustomer(customerRequest);
		log.info("Customer Response:::::" + newCustomerDetails);
		return new ResponseEntity<>(newCustomerDetails, HttpStatus.CREATED);
	}	
}