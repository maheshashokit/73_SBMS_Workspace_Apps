package com.ashokit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ashokit.entity.Employee;

public interface EmployeeDao extends MongoRepository<Employee, String> {
	
	//Finder Method
	public Optional<Employee> findByNameAndDesignation(String name,String designation);
	
	//Query Method
	@Query(value = "{designation: ?0}")
	public List<Employee> getAllEmployeesByDesignation(String designation);
	
}