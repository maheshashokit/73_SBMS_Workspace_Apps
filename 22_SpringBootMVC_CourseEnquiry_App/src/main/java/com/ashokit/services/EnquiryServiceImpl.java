package com.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ashokit.dao.Enquiry;
import com.ashokit.dao.EnquiryDao;

@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
	private EnquiryDao enquiryDao;

	@Override
	public List<Enquiry> getAllEnquires() {
		return enquiryDao.findAll();
	}
	
	@Override
	public Page<Enquiry> getAllEnquiresByPages(int pageNo, int pageSize) {		
		 Pageable pageEnquiries = PageRequest.of(pageNo-1, pageSize);
		 return enquiryDao.findAll(pageEnquiries);
	}
	
	@Override
	public Page<Enquiry> getAllEnquiresSortByPage(int pageNo, int pageSize, String sortField, String sortDirection) {
		
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			                                                                    Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	
		return this.enquiryDao.findAll(pageable);
	}

}
