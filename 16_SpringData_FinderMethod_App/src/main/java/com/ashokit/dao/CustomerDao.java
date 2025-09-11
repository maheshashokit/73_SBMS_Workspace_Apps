package com.ashokit.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.ashokit.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer, Serializable>{
	
    //1. Single column finder methods
	public List<Customer> findByName(String name);
	
	public List<Customer> findByLocation(String location);
	
	//2. single column finder method with pagination support
	public Page<Customer> findByLocation(String location,Pageable pageable);
	
	//3.multiple columns finder methods using conjunction operator
	public List<Customer> findByNameAndLocation(String name,String location);
	
	//4.multiple columns finder methods using conjunction operator with sorting capability
	public List<Customer> findByNameAndLocation(String name,String location,Sort sort);
	
	public Integer countByName(String name);
	
	//5. finder methods on billAmount field
	public Iterable<Customer> findByBillAmountLessThan(float billAmount);
	
	public Iterable<Customer> findByBillAmountGreaterThanEqual(float billAmount);
	
	public Iterable<Customer> findByBillAmountBetween(float startBillAmount,float endBillAmount);
	
	public List<Customer> findByNameAndBillAmount(String name,float billAmount);
	
	public List<Customer> findByNameStartsWith(String name);
	
	public List<Customer> findByNameContainingIgnoreCase(String name);
	
	
}
