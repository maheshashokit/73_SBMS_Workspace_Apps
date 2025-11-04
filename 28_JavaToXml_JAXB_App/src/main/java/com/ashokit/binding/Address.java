package com.ashokit.binding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class Address {
	
	private String doorNo;
	
	private String cityName;
	
	private String state;
	
	private String type;

	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String doorNo, String cityName, String state,String type) {
		super();
		this.doorNo = doorNo;
		this.cityName = cityName;
		this.state = state;
		this.type = type;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", cityName=" + cityName + ", state=" + state + ", type=" + type + "]";
	}
}
