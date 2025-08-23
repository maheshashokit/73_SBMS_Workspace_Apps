package com.ashokit.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private String doorNo;

	private String streetName;

	private String cityName;

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", cityName=" + cityName + "]";
	}

}
