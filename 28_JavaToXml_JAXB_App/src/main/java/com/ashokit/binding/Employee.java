package com.ashokit.binding;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("employee")
public class Employee {
	
	@JsonProperty(value = "employeeId")
	private Integer id;
	
	@JsonProperty(value="employeeName")
	private String name;
	
	@JsonProperty(value="employeeDesignation")
	private String desgination;
	
	@JsonProperty(value="employeeSalary")
	private double salary;
	
	@JsonProperty(value="employeeDoj")
	@JsonSerialize(using = CustomDateSerialzer.class)
	@JsonDeserialize(using=CustomDateDeserializer.class)
	private Date createdDate;
	
	private JobDetails jobDetails;
	
	private List<Address> address;

	public Employee() {
	
	}
	
	public Employee(Integer id, String name, String desgination, double salary) {
		this.id = id;
		this.name = name;
		this.desgination = desgination;
		this.salary = salary;
	}
	
	public Employee(Integer id, String name, String desgination, double salary,JobDetails jobDetails) {
		this.id = id;
		this.name = name;
		this.desgination = desgination;
		this.salary = salary;
		this.jobDetails = jobDetails;
	}
	
	public Employee(Integer id, String name, String desgination, double salary,JobDetails jobDetails,List<Address> address) {
		this.id = id;
		this.name = name;
		this.desgination = desgination;
		this.salary = salary;
		this.jobDetails = jobDetails;
		this.address = address;
	}
	
	public Employee(Integer id, String name, String desgination, double salary,Date createdDate,JobDetails jobDetails,List<Address> address) {
		this.id = id;
		this.name = name;
		this.desgination = desgination;
		this.salary = salary;
		this.jobDetails = jobDetails;
		this.address = address;
		this.createdDate = createdDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
	
	public JobDetails getJobDetails() {
		return jobDetails;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", desgination=" + desgination + ", salary=" + salary
				+ ", createdDate=" + createdDate + ", jobDetails=" + jobDetails + ", address=" + address + "]";
	}
}
