package com.ashokit.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ashokit.dao.PersonDao;
import com.ashokit.dto.PersonDTO;
import com.ashokit.entity.Person;
import com.ashokit.exceptions.ResourceNotFoundException;
import com.ashokit.response.PageResponse;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PersonDTO createNewPerson(PersonDTO personDTO) throws Exception {
		
		//Input Received as DTO and we need to Convert into Entity Class i.e.,Person
		Person personObj = this.modelMapper.map(personDTO, Person.class);
		
		//Setting Current Data While inserting the record
		personObj.setCreatedDate(LocalDate.now());
		//personObj.setUpdatedDate(LocalDate.now());
		
		//save the personObj into Database
		Person savedPersonObj = personDao.save(personObj);
		
		//Converting Back from Entity Class Object into DTO Class Object
		PersonDTO savedPersonDetails = this.modelMapper.map(savedPersonObj, PersonDTO.class);
		
		return savedPersonDetails;
	}

	@Override
	public List<PersonDTO> getAllPersons() {
		
		List<Person> allPersons = personDao.findAll();
		
		//converting from List<Person> into List<PersonDTO>
		//allPersons.stream()  -> converting List<Person> into Stream<Person> object
		//map() -> Its is a intermediate stream operation which take one input(Person) and give it as one output(PersonDTO)
		//collect() -> It is a terminal operation to collect data into single object
		//Collectors -> It is utility class from Java8 Stream library to collect data into list,set,map object
		// i.e..,Collectors.toList(), Collectors.toSet(), Collectors.toMap()
		List<PersonDTO> allPersonDtos = allPersons.stream().map(eachPerson ->{
			return new PersonDTO(eachPerson.getId(),eachPerson.getName(),
					             eachPerson.getLocation(),eachPerson.getEmailId(),
					             eachPerson.getAddress(),eachPerson.getCreatedDate());
		}).collect(Collectors.toList());
		
		return allPersonDtos;
	}
	
	
	@Override
	public PageResponse getAllPersons(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {
		//sortBy ::: Sorting Field
		Sort sort = Sort.by(sortBy).descending();
		if("asc".equalsIgnoreCase(sortDirection)) {
			sort = sort.by(sortBy).ascending();
		}
		
		//Creating the PageRequest Object
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		
		//Get All the Records based on Pagination
		Page<Person> pageInfo = personDao.findAll(pageable);
		
		//Getting the pagecontent from above Page object
		List<Person> personList = pageInfo.getContent();
		
		//Converting List<Person> into List<PersonDTO>
		//modelMapper -> predefined class from modelMapper library.
		//            -> We represented this class as spring bean then we can autowire anywhere in our application
		//            -> Modelmapper contains map() which takes two arguments first argument-> source type
		//            ->                                                      Second argument -> destination type
		//            ->                                                      return type  -> destination type
		List<PersonDTO> personDTOList = personList.stream()
				.map(eachPerson -> this.modelMapper.map(eachPerson, PersonDTO.class))
		        .collect(Collectors.toList());
		
		//Creating PageResponse Object for setting pagination Information
		PageResponse pageResponse = new PageResponse();
		pageResponse.setContent(personDTOList);
		pageResponse.setPageNumber(pageInfo.getNumber());
		pageResponse.setPageSize(pageInfo.getSize());
		pageResponse.setTotalElements(pageInfo.getTotalElements());
		pageResponse.setTotalPages(pageInfo.getTotalPages());
		pageResponse.setLastPage(pageInfo.isLast());
		
		return pageResponse;
	}
	
	@Override
	public PersonDTO updatePersonDetails(PersonDTO personDTO)throws ResourceNotFoundException{
		
		//Fetching Existing Person Details
		Optional<Person> existingPersonDetails = personDao.findById(personDTO.getId());
		
		if(existingPersonDetails.isPresent()) {
			//convert from DTO to Entity
			Person personDetails = this.modelMapper.map(personDTO, Person.class);

			//updating the record
			personDetails.setCreatedDate(existingPersonDetails.get().getCreatedDate());
			Person updatedPersonDetails = personDao.save(personDetails);
			
			//Converting from Entity To DTO
			PersonDTO updatePersonDTODetails = this.modelMapper.map(updatedPersonDetails, PersonDTO.class);
			
		    return updatePersonDTODetails;
		}else {
			throw new ResourceNotFoundException("Person", "PersonID", personDTO.getId());
		}
	}
	
	@Override
	public PersonDTO updatePersonLocationDetails(Integer personId, String newLocation) {
		//Fetching Existing Person Details
		Optional<Person> existingPersonDetails = personDao.findById(personId);
		if(existingPersonDetails.isPresent()) {
			Person personDetails= existingPersonDetails.get();
			//Setting the newLocation into Old Location
			personDetails.setLocation(newLocation);
			//saving the person information
			Person updatedPersonDetails = personDao.save(personDetails);
			//converting from entity class into DTO Class
			return this.modelMapper.map(updatedPersonDetails, PersonDTO.class);
		}else {
			throw new ResourceNotFoundException("Person", "PersonID", personId);
		}
	}
	
	@Override
	public String deletePersonDetailsById(Integer personId) {
		//Fetching Existing Person Details
		Optional<Person> existingPersonDetails = personDao.findById(personId);
		if(existingPersonDetails.isPresent()) {
			personDao.deleteById(personId);
			return String.format("%s Deleted Successfully", personId);
		}else {
			throw new ResourceNotFoundException("Person", "PersonID", personId,"Exception Occured in Delete...");
		}
	}
	
	@Override
	public String uploadProfilePicture(String imageLocation, MultipartFile multipartImage) throws Exception{
		
		//getting the original FileName i.e.,UserUploadedImage file name
		String originalFilename = multipartImage.getOriginalFilename();
		System.out.println("Original File Name::::" + originalFilename);
		
		//Renaming the File Name
		String randomID = UUID.randomUUID().toString();
		System.out.println("RandomID:::::" + randomID);
	
		//user.jpeg,user_profile.png
		String substringfileName= originalFilename.substring(originalFilename.lastIndexOf("."));//.png
		System.out.println("SubString file name::::" + substringfileName);
		String renamedFileName = randomID.concat(substringfileName);
		System.out.println("RenamedFileName:::::" + renamedFileName);
		
		//FilePath to be stored i.e.,profilepics-1/adafafafafafewrewrewrwerwrewrwerew.png
		String destinationFilePath = imageLocation+File.separator+renamedFileName;
		System.out.println("Destination File Path::::" + destinationFilePath);
		
		//creating the folder if not exists
		File fileFolder = new File(imageLocation);//profilepics
		if(!fileFolder.exists()) fileFolder.mkdir();
		
		//Copying the file
		Files.copy(multipartImage.getInputStream(), Paths.get(destinationFilePath));
		
		return renamedFileName;
	}
}
