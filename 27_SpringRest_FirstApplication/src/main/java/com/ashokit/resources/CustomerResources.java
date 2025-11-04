package com.ashokit.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.dto.Customer;
import com.ashokit.utils.CustomerUtils;

@RestController
@RequestMapping("/api/customers")
public class CustomerResources {
	
	@GetMapping(value="/")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> allCustomers = CustomerUtils.getAllCustomers();
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@GetMapping(value="/{customerId}")
	public ResponseEntity<?> getCustomersDetails(@PathVariable("customerId") String customerId){
		//Get All Customers
		List<Customer> allcustomers = CustomerUtils.getAllCustomers();
		
		//filtering the customer based on customerId path variable
		Optional<Customer> customerOpt = allcustomers.stream()
				.filter(eachCustomer -> eachCustomer.getCustId().equals(customerId))
				.findFirst();
		
		if(customerOpt.isPresent()) {
			return new ResponseEntity<Customer>(customerOpt.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Customer Data Not Found With Supplied CustomerId...",HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/", consumes = {MediaType.APPLICATION_JSON_VALUE},
			                produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> creatingNewCustomer(@RequestBody Customer customer){
		System.out.println("Customer Object:::::" + customer);
	    Optional<Customer> custOpt = Optional.of(customer);
	    String customerId="0";
	    if(custOpt.isPresent()) {
		  customerId = customer.getCustId();
	    }
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
		
	}
}