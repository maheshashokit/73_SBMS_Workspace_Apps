package com.ashokit.beans;

public class Welcome {
	
	//Defining the property
	private String message;
	
	//setter based injection
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void displayData() {
		System.out.println("Message =" + message);
	}
	
	//java.lang.object >>> tostring() >>> Welcome@a3d458e
	@Override
	public String toString() {
		return message;
	}
	
}