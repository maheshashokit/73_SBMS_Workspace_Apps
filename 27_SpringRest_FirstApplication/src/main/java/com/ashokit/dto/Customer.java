package com.ashokit.dto;

public class Customer {
	
	private String custId;
	
	private String custName;
	
	private String custLocation;

	public Customer(String custId, String custName, String custLocation) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custLocation = custLocation;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custLocation=" + custLocation + "]";
	}

	

}
