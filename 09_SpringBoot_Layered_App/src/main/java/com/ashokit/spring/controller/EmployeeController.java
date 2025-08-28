package com.ashokit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ashokit.spring.beans.Employee;
import com.ashokit.spring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//we are adding new employee to system which will employee information in employee object
	public void addingNewEmployee(Employee emp) {
		boolean createNewEmployee = employeeService.createNewBrandEmployee(emp);
		if(createNewEmployee) {
			System.out.println("New Employee got onboarded...");
		}else {
			System.out.println("Employee Not onboarded due to some technical issue.");
		}
	}
	
	public void addingNewEmployees(List<Employee> employees) {
		//calling the service method
		employeeService.createBrandNewEmployees(employees);
	}

}
