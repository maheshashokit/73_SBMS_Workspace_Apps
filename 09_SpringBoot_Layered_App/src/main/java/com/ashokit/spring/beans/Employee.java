package com.ashokit.spring.beans;

public class Employee {
	
	private String employeeId;
	
	private String employeeName;
	
	private String emailId;
	
	public Employee() {
		System.out.println("Employee Constructor...");
	}

	public Employee(String employeeId, String employeeName, String emailId) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emailId = emailId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailId=" + emailId + "]";
	}
}