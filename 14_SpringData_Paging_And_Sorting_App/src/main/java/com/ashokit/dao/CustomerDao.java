package com.ashokit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ashokit.enities.Customer;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer>, CrudRepository<Customer, Integer>{

}