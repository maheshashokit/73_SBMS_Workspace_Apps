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

import com.ashokit.request.AddressRequest;
import com.ashokit.response.AddressResponse;
import com.ashokit.response.AddressResponseList;
import com.ashokit.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/address")
@Slf4j
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	//Getting All addresses
	@GetMapping(value = "/")
	public ResponseEntity<?> fetchAllAddresses(){
		log.debug("Start: Inside the Get Endpoint of Address Microservice....");
		List<AddressResponse> allAddress = addressService.getAllAddresses();
		
		//converting List<AddressResponse> into AddressResponseList
		AddressResponseList addressResponseList = new AddressResponseList();
		addressResponseList.setAddressResponseList(allAddress);
		log.debug("End: Inside the Get Endpoint of Address Microservice....");
		return ResponseEntity.ok(addressResponseList);
	}
	
	//Getting particular address i.e.,Address lookup API
	@GetMapping(value = "/{addressId}")
	public ResponseEntity<?> fetchAddressById(@PathVariable("addressId") Integer addressId){
		AddressResponse customerDetails = addressService.getAddressById(addressId);
		return ResponseEntity.ok(customerDetails);
	}
	
	//Getting particular customer address based on customerId	
	//    /api/address/customer/123
	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<?> fetchAddressByCustomerId(@PathVariable("customerId") Integer customerId){
		log.debug("Start: Inside the Get Endpoint of Address Microservice in customerId....");
		AddressResponse customerDetails = addressService.getAddressByCustomerId(customerId);
		log.debug("End: Inside the Get Endpoint of Address Microservice in customerId....");
		return ResponseEntity.ok(customerDetails);
		//return new ResponseEntity(customerDetails,HttpStatus.OK);
	}
	
	//creating new address
	@PostMapping(value = "/")
	public ResponseEntity<?> createNewAddressForCustomer(@RequestBody AddressRequest addressRequest){
		AddressResponse newCustomerDetails = addressService.createAddress(addressRequest);
		return new ResponseEntity<>(newCustomerDetails, HttpStatus.CREATED);
	}	
}
