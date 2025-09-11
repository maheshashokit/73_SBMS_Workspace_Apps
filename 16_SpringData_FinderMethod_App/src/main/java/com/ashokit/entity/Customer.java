package com.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ashokit_customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "customer_name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "bill_amount")
	private float billAmount;
	
	public Customer() {		
	}
	
	public Customer(Integer customerId, String name, String location, float billAmount) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.location = location;
		this.billAmount = billAmount;
	}
	
	public Customer(String name, String location, float billAmount) {
		this.name = name;
		this.location = location;
		this.billAmount = billAmount;
	}	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", location=" + location + ", billAmount="
				+ billAmount + "]";
	}
}
