package com.ashokit.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ashokit_customers")
public class Customer {
	
	@Id
	@GeneratedValue  //Auto Strategy
	@Column(name="customer_id")
	private Integer cutomerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_location")
	private String customerLocation;
	
	public Customer() {
		
	}
	
	public Customer(Integer cutomerId, String customerName, String customerLocation) {
		this.cutomerId = cutomerId;
		this.customerName = customerName;
		this.customerLocation = customerLocation;
	}
	
	public Customer(String customerName, String customerLocation) {
		this.customerName = customerName;
		this.customerLocation = customerLocation;
	}

	public void setCutomerId(Integer cutomerId) {
		this.cutomerId = cutomerId;
	}
	
	public Integer getCutomerId() {
		return cutomerId;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}
	
	public String getCustomerLocation() {
		return customerLocation;
	}

	@Override
	public String toString() {
		return "Customer [cutomerId=" + cutomerId + ", customerName=" + customerName + ", customerLocation="
				+ customerLocation + "]";
	}
}