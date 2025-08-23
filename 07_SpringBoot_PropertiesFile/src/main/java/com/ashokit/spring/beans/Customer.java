package com.ashokit.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	@Value("${customerId}")
	private String custId;
	
	@Value("${customerName}")
	private String custName;
	
	@Value("${customerLocation}")
	private String custLocation;
	
	//System variable
	@Value("${username}")
	public String systemUserName;

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custLocation=" + custLocation
				+ ", systemUserName=" + systemUserName + "]";
	}

	
}