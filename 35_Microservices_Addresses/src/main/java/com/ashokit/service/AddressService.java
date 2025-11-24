package com.ashokit.service;

import java.util.List;

import com.ashokit.request.AddressRequest;
import com.ashokit.response.AddressResponse;

public interface AddressService {
	
	public AddressResponse createAddress(AddressRequest request);
	
	public AddressResponse getAddressById(Integer addressId);
	
	public AddressResponse getAddressByCustomerId(Integer customerId);
	
	public List<AddressResponse> getAllAddresses();
	
}
