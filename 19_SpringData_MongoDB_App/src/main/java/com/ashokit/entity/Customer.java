package com.ashokit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
	
	@Id
	private Integer customerId;
	
	private String customerName;
	
	private String cusotmerlocation;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCusotmerlocation() {
		return cusotmerlocation;
	}

	public void setCusotmerlocation(String cusotmerlocation) {
		this.cusotmerlocation = cusotmerlocation;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", cusotmerlocation="
				+ cusotmerlocation + "]";
	}
}