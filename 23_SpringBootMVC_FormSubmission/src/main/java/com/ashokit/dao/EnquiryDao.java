package com.ashokit.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.ashokit.entity.Enquiry;

import jakarta.transaction.Transactional;

public interface EnquiryDao extends ListCrudRepository<Enquiry, Serializable>,ListPagingAndSortingRepository<Enquiry, Serializable> {
	
	@Query(value = "update ashokit_enquires set email=:emailId,contact_no=:contactNo where enquiry_id=:enquiryId", nativeQuery = true)
	@Modifying
	@Transactional	
	public int updateEnquiryDetails(int enquiryId,String emailId,String contactNo);

}
