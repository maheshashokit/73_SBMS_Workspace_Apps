package com.ashokit.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseBean {
	
	@Value("${databaseUserName}")
	private String userName;
	
	@Value("${databasePassword}")
	private String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DatabaseBean [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
