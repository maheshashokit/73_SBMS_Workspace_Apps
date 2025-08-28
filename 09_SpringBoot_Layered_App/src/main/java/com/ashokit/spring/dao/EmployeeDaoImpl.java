package com.ashokit.spring.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashokit.spring.beans.Employee;
import com.ashokit.spring.utils.EmployeeResultSetExtractor;
import com.ashokit.spring.utils.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	//Perform database operations using one centralized class from spring boot jdbc library
	//We are getting JdbcTemplate class object through spring boot AutoConfiguration
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource datasource;

	@Override
	public boolean createEmployee(Employee emp) {
		
		System.out.println("DataSource Implementation Class from SpringBoot::::" + datasource.getClass().getName());
		
		//legacy style for inserting current data into db
		java.sql.Date recordCreatedDate = new java.sql.Date(new java.util.Date().getTime());
		
		int rowCount = jdbcTemplate.update("insert into ashokit_emp values(?,?,?,?)", emp.getEmployeeId(), emp.getEmployeeName(), 
				                                                                      emp.getEmailId(),LocalDateTime.now());
		
		//If row inserted successfully will return rowCount values as +ve otherwise -ve
		return rowCount > 0;
	}
	
	
	@Override
	public int createEmployees(List<Employee> employees) {
		
		int rowCount=0;
		for(Employee emp : employees) {
			rowCount += jdbcTemplate.update("insert into ashokit_emp values(?,?,?,?)", emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmailId(), LocalDateTime.now());
		}
		System.out.println("Row Count Checking Variable ::::::" + rowCount);
		return rowCount;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = jdbcTemplate.query("select emp_id,emp_name,email_id from ashokit_emp", new EmployeeResultSetExtractor());
		return allEmployees;
	}
	
	@Override
	public List<Employee> getAllEmps() {
		 List<Employee> allEmps = jdbcTemplate.query("select emp_id,emp_name,email_id from ashokit_emp", new EmployeeRowMapper());
		 return allEmps;		
	}
}
