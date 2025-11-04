package com.ashokit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ashokit.dto.PersonDTO;
import com.ashokit.response.PageResponse;

public interface PersonService {
	
	//creating the new Person
	public PersonDTO createNewPerson(PersonDTO personDTO) throws Exception;
	
	//Getting all Persons with out pagination
	public List<PersonDTO> getAllPersons();

	//Getting all Persons with pagination
	public PageResponse getAllPersons(Integer pageNumber,Integer pageSize,String sortBy,String sortDirection);
	
	//Updating the Person Details
	public PersonDTO updatePersonDetails(PersonDTO personDTO);
	
	//Updating the Person Location field only
	public PersonDTO updatePersonLocationDetails(Integer personId,String newLocation);

	//Deleting the Person Details
	public String deletePersonDetailsById(Integer personId);
	
	//supporting for uploading
	public String uploadProfilePicture(String imageLocation, MultipartFile multipartImage) throws Exception;
}
