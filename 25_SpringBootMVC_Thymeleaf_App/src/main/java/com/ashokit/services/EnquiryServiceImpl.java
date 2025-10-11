package com.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dao.EnquiryDao;
import com.ashokit.entites.Enquiry;

@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
    private EnquiryDao enquiryDao;
	
	@Override
	public List<Enquiry> showAllEnquires() {
		return enquiryDao.findAll();
	}
	
	@Override
	public Enquiry getEnquiryById(int enquiryId) {
		return enquiryDao.findById(enquiryId).get();
	}
	
	@Override
	public boolean saveEnquiryDetails(Enquiry enquiry) {
		Enquiry savedEntity = enquiryDao.save(enquiry);
		return savedEntity.getEnquiryId() > 0;
	}
	
	@Override
	public void deleteEnquiryDetails(int enquiryId) {
	   enquiryDao.deleteById(enquiryId);	
	}
}