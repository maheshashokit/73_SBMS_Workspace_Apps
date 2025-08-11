package com.ashokit.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Demo {
	
	@Autowired
	@Qualifier("currentUser1")
	private User user;
	
	//business method of demo class
	public void displayData() {
		//calling dependent class service method
		String userDetails = user.getUserDetails();
		System.out.println(userDetails);
	}

}
