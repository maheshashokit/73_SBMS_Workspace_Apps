package com.ashokit.spring.beans;

public class User {
	
	private String username;
	
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public String getUserDetails() {
		return String.format("Username %s and Password %s", username,password);
	}
}