package com.ashokit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.spring.beans.Employee;
import com.ashokit.spring.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public boolean createNewBrandEmployee(Employee emp) {
		//calling DAO method from Service layer
		return employeeDao.createEmployee(emp);
	}
	
	@Override
	public void createBrandNewEmployees(List<Employee> employees) {
		 int dbInsertedEmployees = employeeDao.createEmployees(employees);
		 if(employees.size() == dbInsertedEmployees) {
			 System.out.println("All Records got Inserted...");
		 }else {
			 System.out.println("Some of Records got missed...");
		 }		
	}

}
