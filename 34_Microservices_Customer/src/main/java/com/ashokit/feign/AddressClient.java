package com.ashokit.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashokit.response.AddressResponse;
import com.ashokit.response.AddressResponseList;

@FeignClient(url= "${address.service.url}",name="Address-Service")
//@FeignClient(name="ADDRESS-SERVICE", path="/api/address")
public interface AddressClient {
	
	@GetMapping(value = "/")
	public ResponseEntity<AddressResponseList> fetchAllAddresses();
	
	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<AddressResponse> fetchAddressByCustomerId(@PathVariable("customerId") Integer customerId);
}