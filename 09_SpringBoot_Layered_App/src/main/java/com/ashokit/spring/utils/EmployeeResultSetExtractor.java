package com.ashokit.spring.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ashokit.spring.beans.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		System.out.println("extractData() method......");
		List<Employee> empList = new ArrayList<Employee>();
		while(rs.next()) {
			Employee emp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3));
			empList.add(emp);
		}
		return empList;
	}
}
