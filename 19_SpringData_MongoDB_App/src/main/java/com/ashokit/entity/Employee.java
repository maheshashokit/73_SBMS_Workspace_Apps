package com.ashokit.entity;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
	
	@Id
	private String id;
	
	private String name;
	
	private String designation;
	
	private String[] emailIds;
	
	private String contactNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String[] getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(String[] emailIds) {
		this.emailIds = emailIds;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", emailIds="
				+ Arrays.toString(emailIds) + ", contactNo=" + contactNo + "]";
	}
}
