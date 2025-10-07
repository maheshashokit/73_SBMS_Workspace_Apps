package com.ashokit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ashokit.entity.Customer;

public interface CustomerDao extends MongoRepository<Customer, Integer> {

}
