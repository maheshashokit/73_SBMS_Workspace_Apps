package com.ashokit.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ashokit.entity.Customer;

import jakarta.transaction.Transactional;

public interface CustomerDao extends CrudRepository<Customer, Integer> {

	@Query(value = "from Customer c", nativeQuery = false)
	public List<Customer> getAllCustomers();

	@Query(value = "select * from ashokit_customers", nativeQuery = true)
	public List<Customer> getAllCustomersByNativeQuery();

	@Query(value = "select customer_name,location from ashokit_customers", nativeQuery = true)
	public List<Object[]> getAllCustomersInfo();

	@Query(value = "select at.name,at.location from Customer at", nativeQuery = false)
	public List<Object[]> getAllCustomersDetails();

	// NamedParameters
	@Query(value = "from Customer c where c.location=:custLocation", nativeQuery = false)
	public List<Customer> getAllCustomersByCity(String custLocation);

	// IndexedParameters
	@Query(value = "from Customer c where c.location=?1", nativeQuery = false)
	public List<Customer> getAllCustomersByLocation(String custLocation);

	// IndexedParameters
	@Query(value = "from Customer c where c.location=?1 and c.billAmount >= ?2", nativeQuery = false)
	public List<Customer> getAllCustomersByLocation(String custLocation, float custbillAmount);

	@Query(value = "update ashokit_customers set location=:custLocation where customer_id=:custId", nativeQuery = true)
	@Modifying
	@Transactional
	public int updateCustomerLocation(String custLocation, Integer custId);

	@Query("delete from Customer c where c.location=?1")
	@Modifying
	@Transactional
	public int deleteCustomersByLocation(String customerLocation);

}
