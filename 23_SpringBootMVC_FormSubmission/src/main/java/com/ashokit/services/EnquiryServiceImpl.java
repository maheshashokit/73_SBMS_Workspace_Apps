package com.ashokit.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ashokit.beans.EnquiryDTO;
import com.ashokit.dao.EnquiryDao;
import com.ashokit.entity.Enquiry;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDao enquiryDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EnquiryDTO createEnquiry(EnquiryDTO enquirydto) {

		//converting the form data into Entity object data for persisting database
		Enquiry enquiry = modelMapper.map(enquirydto, Enquiry.class);
		enquiry.setCreatedDate(new java.util.Date());
		
		//saving the data into database
		Enquiry savedEnquiry = enquiryDao.save(enquiry);

		//converting from Entity to DTO Object.
		return modelMapper.map(savedEnquiry, EnquiryDTO.class);
	}
	
	@Override
	public List<EnquiryDTO> getAllEnquires() {
		
		//getting all enquires Info from Database
		List<Enquiry> allEnquires = enquiryDao.findAll();
		
		//conversion from entity object into dto object
		List<EnquiryDTO> allEnquiresInfo = allEnquires.stream()
				.map(eachEnquiryInfo -> modelMapper.map(eachEnquiryInfo, EnquiryDTO.class))
				.collect(Collectors.toList());
		
		return allEnquiresInfo;
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
	
	@Override
	public EnquiryDTO getEnquiryDetailsById(int enquiryId) {
		Optional<Enquiry> enquiryDetails = enquiryDao.findById(enquiryId);
		EnquiryDTO enquiryFinalInfo = null;
		if(enquiryDetails.isPresent()) {
			Enquiry enquiryInfo = enquiryDetails.get();
			
			//converting from Enquiry To EnquiryDTO
			enquiryFinalInfo = modelMapper.map(enquiryInfo, EnquiryDTO.class);
		}
		System.out.println("Enquiry Info:::::" + enquiryFinalInfo);
		System.out.println("Enquiry ID:::::" + enquiryId);
		return enquiryFinalInfo;
	}
	
	@Override
	public boolean updateEnquiry(EnquiryDTO enquiryDTO) {
		
		int updateEnquiryDetails = enquiryDao.updateEnquiryDetails(enquiryDTO.getEnquiryId(), enquiryDTO.getEmailId(), enquiryDTO.getContactNo());		
		return updateEnquiryDetails > 0;
	}
}
