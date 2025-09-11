package com.ashokit.services;

public interface CustomerService {
	
	public void fetchCustomersByName(String name);
	
	public void fetchCustomersByNameAndLocation(String name ,String location);
	
	public void fetchCustomersByLocationWithPagination(String location,int pageSize,int currentPage);
	
	public void getCountOfCustomerName(String name);
	
	public void fetchCustomersBetweenBillAmount(float stBillAmount,float endBillAmount);

}
