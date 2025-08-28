package com.ashokit.spring.service;

import java.util.List;

import com.ashokit.spring.beans.Employee;

public interface EmployeeService {
	
	public boolean createNewBrandEmployee(Employee emp);
	
	public void createBrandNewEmployees(List<Employee> employees);

}
