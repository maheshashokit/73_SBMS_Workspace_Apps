package com.ashokit.spring.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ashokit.spring.beans.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		 System.out.println("MapRow() calling......");
		 Employee emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3));
		 return emp;			
	}
}
