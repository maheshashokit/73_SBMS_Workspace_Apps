package com.ashokit.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ashokit.dao.Enquiry;

//POJI-POJO
public interface EnquiryService {
	
	//Getting the all enquires information with out pagination
	public List<Enquiry> getAllEnquires();
	
	//Getting all enquires information with pagination
	public Page<Enquiry> getAllEnquiresByPages(int pageNo,int pageSize);
	
	//Getting all enquires information with pagination and Sorting support
	public Page<Enquiry> getAllEnquiresSortByPage(int pageNo,int pageSize,String sortField,String sortDirection);
}
