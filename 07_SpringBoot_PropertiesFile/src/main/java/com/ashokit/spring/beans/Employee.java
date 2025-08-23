package com.ashokit.spring.beans;

import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.ashokit")
public class Employee {

	private String id;

	private String name;

	private float salary;

	private Address address;

	private String[] colors;

	public void setId(String id) {
		System.out.println("Setter Method sop statement....");
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + ", colors="
				+ Arrays.toString(colors) + "]";
	}

}
