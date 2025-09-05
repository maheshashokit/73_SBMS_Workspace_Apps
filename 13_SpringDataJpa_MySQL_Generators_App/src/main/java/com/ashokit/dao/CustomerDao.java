package com.ashokit.dao;

import org.springframework.data.repository.CrudRepository;

import com.ashokit.entity.Customer;

//Automatically Consider as Spring bean we can autowire anywhere application
public interface CustomerDao extends CrudRepository<Customer, Integer> {

}
