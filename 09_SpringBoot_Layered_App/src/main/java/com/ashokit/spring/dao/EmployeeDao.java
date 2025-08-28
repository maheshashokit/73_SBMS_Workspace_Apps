package com.ashokit.spring.dao;

import java.util.List;

import com.ashokit.spring.beans.Employee;

public interface EmployeeDao {
	
	//creating single employee
	public boolean createEmployee(Employee emp);
	
	//creating bulk of employees
	public int createEmployees(List<Employee> employees); 
	
	//selecting employees
	public List<Employee> getAllEmployees();
	
	//selecting employees with rowMapper
	public List<Employee> getAllEmps();
	
	//Task - Implement Update & delete Operation

}
