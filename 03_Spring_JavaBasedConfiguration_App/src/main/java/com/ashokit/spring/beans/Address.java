package com.ashokit.spring.beans;

public class Address {
	
	private String doorNo;
	
	private String cityName;
	
	private String pincode;

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", cityName=" + cityName + ", pincode=" + pincode + "]";
	}
}
