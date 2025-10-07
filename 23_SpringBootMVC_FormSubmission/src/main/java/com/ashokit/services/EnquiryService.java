package com.ashokit.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ashokit.beans.EnquiryDTO;
import com.ashokit.entity.Enquiry;

public interface EnquiryService {

	// Creating new Enquiry Info
	public EnquiryDTO createEnquiry(EnquiryDTO enquiry);

	// Getting All Enquires Info
	public List<EnquiryDTO> getAllEnquires();

	// Getting all enquires information with pagination
	public Page<Enquiry> getAllEnquiresByPages(int pageNo, int pageSize);

	// Getting all enquires information with pagination and Sorting support
	public Page<Enquiry> getAllEnquiresSortByPage(int pageNo, int pageSize, String sortField, String sortDirection);
	
	//Getting particular Enquiry Information
	public EnquiryDTO getEnquiryDetailsById(int enquiryId);
	
	public boolean updateEnquiry(EnquiryDTO enquiryDTO);

}
