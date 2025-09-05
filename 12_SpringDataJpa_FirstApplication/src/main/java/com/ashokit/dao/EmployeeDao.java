package com.ashokit.dao;

import org.springframework.data.repository.CrudRepository;

import com.ashokit.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
