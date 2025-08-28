package com.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashokit.spring.beans.Employee;
import com.ashokit.spring.controller.EmployeeController;
import com.ashokit.spring.dao.EmployeeDao;
import com.ashokit.spring.utils.EmployeeUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		
		//Getting Controller Object
		EmployeeController empController = context.getBean(EmployeeController.class);
		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
	
		//Getting EmployeeUtils Object for getting employees
		EmployeeUtils employeeUtils = context.getBean(EmployeeUtils.class);
		List<Employee> employees = employeeUtils.getAllEmployeesInfo();
		//Preparing Employee object to be on-board
	    Employee emp = new Employee("12345","Mahesh","mahesh.ashokit@gmail.com");
				
		
		//calling the controller method
		//empController.addingNewEmployee(emp);
		//empController.addingNewEmployees(employees);
		employeeDao.getAllEmployees().forEach(eachEmployee -> System.out.println(eachEmployee));
		System.out.println();
		employeeDao.getAllEmps().forEach(eachEmployee -> System.out.println(eachEmployee));
	}
}