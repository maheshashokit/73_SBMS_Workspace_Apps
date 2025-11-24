package com.ashokit.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ashokit.dao.CustomerDao;
import com.ashokit.entity.Customer;
import com.ashokit.feign.AddressClient;
import com.ashokit.request.CustomerRequest;
import com.ashokit.response.AddressResponse;
import com.ashokit.response.AddressResponseList;
import com.ashokit.response.ApiResponse;
import com.ashokit.response.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	@Value("${address.service.url}")
	private String addressServiceUrl;
	
	@Autowired
	private AddressClient addressClient;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
		
	@Override
	public CustomerResponse createCustomer(CustomerRequest customerRequest) {
		//converting from CustomerRequest To Entity Class Object
		Customer customer = convertingFromRequestToEntity(customerRequest);
		//Saving Customer Information
		Customer savedCustomer = this.customerDao.save(customer);
		//Converting From Customer Entity to CustomerResponse Object
		return this.convertingEntityToResponse(savedCustomer);
	}

	@Override
	public ApiResponse getCustomerById(Integer customerId) {
		Optional<Customer> customerDetails = this.customerDao.findById(customerId);
		if (customerDetails.isPresent()) {
			Customer custDetails = customerDetails.get();
			
			CustomerResponse customerResponse = this.convertingEntityToResponse(custDetails);
			
			//Address Microservice interaction
			//AddressResponse addressResponse = callingAddressServiceWithRestTemplate(customerId);
			//AddressResponse addressResponse = callingAddressServiceWithWebClient(customerId);	
			AddressResponse addressResponse = addressClient.fetchAddressByCustomerId(customerId).getBody();
			//AddressResponse addressResponse = callAddressServiceByUsingDiscoveryClient(customerId);
			
			//setting addressResponse into customerResponse
			//customerResponse.setAddressResponse(addressResponse);
			
			ApiResponse apiResponse = new ApiResponse();
			apiResponse.setCustomerDetails(customerResponse);
			apiResponse.setAddressDetails(addressResponse);
					
			return apiResponse;
		}else {
			//throw the exception
			return null;
		}
	}
	
	
	
	@Override
	public List<CustomerResponse> getAllCustomers() {
	
		//Getting All Customers Details
		List<Customer> allCustomers = this.customerDao.findAll();
		
		//converting from List<Customer> into List<CustomerResponse> Using Java8 streams
		List<CustomerResponse> allCustomerResponse = 
				allCustomers.stream() // converting the list of customer into stream of customer
				            .map(eachCustomer -> {
				            	return convertingEntityToResponse(eachCustomer);
				             }) //It will transform the customer object into customeresponse object
							.collect(Collectors.toList()); //collecting each customerresponse object into list object
		
		//Calling the Address MicroService to get All Addresses
		//AddressResponseList allAddressResponse = callingAddressServiceForAllAddressWithRestTemplate();
		//AddressResponseList allAddressResponse = callingAddressServiceForAllAddressWithWebClient();
		AddressResponseList allAddressResponse = addressClient.fetchAllAddresses().getBody();
		
		//Mapping the Address with Customer
		/*List<CustomerResponse> customerAddressResponse = new ArrayList<>();
		for(CustomerResponse customerResponse: allCustomerResponse) {
			System.out.println("CustomerId::::"+ customerResponse.getId());
			for(AddressResponse addressResponse1 : allAddressResponse.getAddressResponseList()) {
				System.out.println("Address:::::" + addressResponse1.getCustomerId());
				System.out.println("Testing:::" + (customerResponse.getId() == addressResponse1.getCustomerId()));
				if(addressResponse1.getCustomerId().toString().equals(customerResponse.getId().toString())) {
					System.out.println("Inside the condition");
					customerResponse.setAddressResponse(addressResponse1);
					customerAddressResponse.add(customerResponse);
				}
			}			
		}*/
		List<CustomerResponse> customerAddressResponse = allCustomerResponse.stream()
				.map(eachCustomer -> {
					 Optional<AddressResponse> add = allAddressResponse.getAddressResponseList().stream()
					.filter(eachAddress ->{
							return eachAddress.getCustomerId().equals(eachCustomer.getId());
						  })
					.findAny();
					//setting AddressResponse to CustomerResponse
					 if(add.isPresent()) {
						 eachCustomer.setAddressResponse(add.get());
					 }else {
						 eachCustomer.setAddressResponse(null); 
					 }
					return eachCustomer;
				 })
			.collect(Collectors.toList());
			
		return allCustomerResponse;
	}
	
	//utility method for converting customerRequest to Entity Object
	private Customer convertingFromRequestToEntity(CustomerRequest customerRequest) {
		//Customer customer = modelMapper.map(customerRequest,Customer.class);
		//System.out.println("Customer::::" + customer);
		return this.modelMapper.map(customerRequest,Customer.class);
	}
	
	//utility method for converting customerRequest to Entity Object
	private CustomerResponse convertingEntityToResponse(Customer customer) {
		CustomerResponse custResponse = this.modelMapper.map(customer,CustomerResponse.class);
		System.out.println("CustomerResponse::::" + custResponse.getCreatedDate());
		return custResponse;
	}
	
	//calling the Address microservice to Fetch Address of particular Customer
	private AddressResponse callingAddressServiceWithRestTemplate(int customerId) {
		//http://localhost:9966/api/address/
		System.out.println("Address Service URL:::" + addressServiceUrl);
		/*ResponseEntity<AddressResponse> addressResponseEntity = 
				restTemplate.getForEntity(addressServiceUrl+"customer/{customerId}",
					   			          AddressResponse.class,
								          customerId
								         );*/
		
		//By Using exchange() of RestTemplate
		ResponseEntity<AddressResponse> addressResponseEntity = 
				restTemplate.exchange(addressServiceUrl+"customer/{customerId}", 
							  HttpMethod.GET,
							  null,
							  AddressResponse.class,
							  customerId);
		
		//checking the API Status
		if(addressResponseEntity.getStatusCode() == HttpStatus.OK) {
			//ResponseBody of API
			if(addressResponseEntity.hasBody()) {
				return addressResponseEntity.getBody();
			}
		}
		return null;
	}
	
	
	private AddressResponse callingAddressServiceWithWebClient(int customerId) {
		AddressResponse addressResponse = webClient
				                          .get()
										  .uri(addressServiceUrl+"customer/"+customerId)
										  .retrieve()
									      .bodyToMono(AddressResponse.class)
										  .block();
		return addressResponse;
	}
 
	//calling the Address micro service to Fetch all address
	private AddressResponseList callingAddressServiceForAllAddressWithRestTemplate() {
		
		ResponseEntity<AddressResponseList> addressResponseEntity = 
				    restTemplate.exchange(addressServiceUrl,
					HttpMethod.GET,
					null,
					AddressResponseList.class);
		
		//checking the API Status
		if(addressResponseEntity.getStatusCode() == HttpStatus.OK) {
			//ResponseBody of API
			if(addressResponseEntity.hasBody()) {
				return addressResponseEntity.getBody();
			}
		}
		return null;
	}
	
	//calling the Address micro service to Fetch Address of particular Customer
	private AddressResponseList callingAddressServiceForAllAddressWithWebClient() {
		AddressResponseList allAddress = webClient.get()
												  .uri(addressServiceUrl)
												  .accept(MediaType.APPLICATION_JSON)
												  .retrieve()
												  .bodyToMono(AddressResponseList.class)
												  .block();
				
	    return allAddress;
	}
	
	
	/*private AddressResponse callAddressServiceByUsingDiscoveryClient(int customerId) {
		//Fetching all Instances related to Address-Service
		List<ServiceInstance> allInstances = discoveryClient.getInstances("ADDRESS-SERVICE");
		
		//Fetching the first instance all available instances
		ServiceInstance currentInstance = allInstances.get(0);
		
		//
		String apiUrl = currentInstance.getUri()+"/api/address/customer/{customerId}";
		System.out.println("API URL ::::" + apiUrl);
		
		ResponseEntity<AddressResponse> addressEntity = 
				   restTemplate.exchange(apiUrl, 
						         HttpMethod.GET,null,
						         AddressResponse.class,
						         customerId);   
		   //checking the API Status is 200 or not
		  if (addressEntity.getStatusCode() == HttpStatus.OK) {
			   //API having Response body or not
			 	if (addressEntity.hasBody()) {
			 		return addressEntity.getBody();
				}
		  }
		 return null;
	}*/

}
