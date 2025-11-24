package com.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ashokit.dao.AddressDao;
import com.ashokit.entity.Address;
import com.ashokit.request.AddressRequest;
import com.ashokit.response.AddressResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private Environment environment;
	
	//private static Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Override
	public AddressResponse createAddress(AddressRequest request) {
		log.debug("Start:Inside the createAddress Method......");
		//converting from AddressRequest To Entity Class Object
		Address address = convertingFromRequestToEntity(request);
		
		
		//Saving Address Information
		Address savedAddress = this.addressDao.save(address);
		
		log.debug("End:Inside the createAddress Method......");
		//Converting From Address Entity to AddressResponse Object
		return this.convertingEntityToResponse(savedAddress);
		
	}

	@Override
	public AddressResponse getAddressById(Integer addressId) {
		log.debug("Start:Inside the getAddressById Method......");
		Optional<Address> addressDetails = this.addressDao.findById(addressId);
		if (addressDetails.isPresent()) {
			log.info("Address Details found from database...");
			Address addDetails = addressDetails.get();
			AddressResponse addressResponse = this.convertingEntityToResponse(addDetails);
			return addressResponse;
		}else {
			log.info("Address Details not found from database....");
			//throw the exception
			return null;
		}
		
	}
	
	@Override
	public AddressResponse getAddressByCustomerId(Integer customerId) {
		System.out.println("PortNumber:::::" + environment.getProperty("server.port"));
		log.debug("Start:Inside the getAddressByCustomerId Method......");
		Optional<Address> addressDetails = this.addressDao.findByCustomerId(customerId);
		if (addressDetails.isPresent()) {
			log.debug("AddressByCustomerId Details found....");
			Address addDetails = addressDetails.get();
			AddressResponse addressResponse = this.convertingEntityToResponse(addDetails);
			return addressResponse;
		}else {
			log.debug("AddressByCustomerId Details Not found....");
			//throw the exception
			return null;
		}
	}

	@Override
	public List<AddressResponse> getAllAddresses() {
		log.debug("Start:Inside the getAllAddresses Method......");
		//Getting All Customers Details
		List<Address> allAddresses = this.addressDao.findAll();
		
		//converting from List<Address> into List<AddressResponse>
		List<AddressResponse> allAddressResponses = 
				allAddresses.stream() //Stream<Address>
				            .map(eachAddress -> {
				            		return convertingEntityToResponse(eachAddress);
				             }) //Intermediate operation to transforming the object
							.collect(Collectors.toList());//terminal operation to collect each addressresponse and adding into list
		log.debug("End:Inside the getAllAddresses Method......");
		//returning CustomerResponse
		return allAddressResponses;
	}
	
	//utility method for converting AddressRequest to Entity Object
	private Address convertingFromRequestToEntity(AddressRequest addressRequest) {
		return this.modelMapper.map(addressRequest,Address.class);
	}
	
	//utility method for converting Entity to AddressResponse Object
	private AddressResponse convertingEntityToResponse(Address address) {
		return this.modelMapper.map(address,AddressResponse.class);
	}
}
