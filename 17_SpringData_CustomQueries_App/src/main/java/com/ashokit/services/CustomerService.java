package com.ashokit.services;

public interface CustomerService {
	
	public void fetchCustomerDetailsUsingNativeQuery();
	
	public void fetchCustomerDetailsUsingHqlQuery();
	
	public void fetchSelectedColumnsUsingNativeQuery();
	
	public void fetchSelectedColumnsUsingHqlQuery();
	
	public void fetchCustomerDetailsByCity(String location);
	
	public void fetchCustomerDetailsByLocation(String location,float billAmount);
}
