package com.ashokit.services;

import java.util.List;

import com.ashokit.entites.Enquiry;

public interface EnquiryService {
	
	public List<Enquiry> showAllEnquires();
	
	public Enquiry getEnquiryById(int enquiryId);
	
	public boolean saveEnquiryDetails(Enquiry enquiry);
	
	public void deleteEnquiryDetails(int enquiryId);

}
