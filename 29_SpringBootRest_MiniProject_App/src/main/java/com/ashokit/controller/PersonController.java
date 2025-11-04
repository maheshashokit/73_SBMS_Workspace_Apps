package com.ashokit.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ashokit.constants.ApplicationConstants;
import com.ashokit.dto.PersonDTO;
import com.ashokit.exceptions.ErrorDetails;
import com.ashokit.exceptions.ResourceNotFoundException;
import com.ashokit.response.PageResponse;
import com.ashokit.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/persons")
@Tag(name="Person",description = "Person Controller Rest API Methods")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	//Getting image location
	@Value("${project.images}")
	private String imageLocation;
	
	@GetMapping(value="/", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "This API is used for getting Persons information with Pagination",
			   description ="This API Will return the Persons information by default with Pagination.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Successfully Retrieved All the Persons Information....."),
		@ApiResponse(responseCode = "500", description = "Failure because of Unable to Retreive Persons Information.....")
	})	
	public ResponseEntity<PageResponse> getAllPersonsInformation(
			@Parameter(description = "Defining the PageNumber To get Particular Page of Person Records default value is 0..") 
			@RequestParam(name="pageNumber",defaultValue=ApplicationConstants.PAGE_NUMBER, required=false) Integer pageNumber,
			
			@Parameter(description = "Defining the PageSize To be displayed no of records in particular page the default value is 10... ") 
			@RequestParam(name="pageSize",defaultValue=ApplicationConstants.PAGE_SIZE, required=false) Integer pageSize,
			
			@Parameter(description = "Defining the field to sort the person records based on supplied value and default value will be personID...") 
			@RequestParam(name="sortBy",defaultValue=ApplicationConstants.SORT_BY, required=false) String sortBy,
			
			@Parameter(description = "Defining the Sort direction for sorting the recoreds and default value will be ascending...") 
			@RequestParam(name="sortDir",defaultValue=ApplicationConstants.SORT_DIR, required=false) String sortDirection){
		
		//Calling service method to get records with pagination
		PageResponse paginationData = personService.getAllPersons(pageNumber,pageSize,sortBy,sortDirection);
		return new ResponseEntity<PageResponse>(paginationData,HttpStatus.OK);
	}
	
	@PostMapping(value="/",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
						   produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "This API is used for Creating new Brand Person Record in Application",
	           description ="This API Will Create new Person Record which accepts the Payload as JSON(or) XML .")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Successfully new brand person record got created...."),
		@ApiResponse(responseCode = "500", description = "Request has been failed due to some technical problem....")
	})
	public ResponseEntity<?> createNewPerson(@RequestBody PersonDTO personDTO) throws Exception{
		PersonDTO savedPersonDTO = personService.createNewPerson(personDTO);
		return new ResponseEntity<PersonDTO>(savedPersonDTO,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			   			  produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@Operation(summary = "This API is used for Updating existing Person Details in Application",
    		   description ="This API Will Modifying Person Details which accepts the Payload as JSON/XML.")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Successfully Updated Person Details....."),
		@ApiResponse(responseCode = "404", description = "RequestBody PersonId is not available...."),
		@ApiResponse(responseCode = "500", description = "Request Failed while processing data.....")
	})
	public ResponseEntity<?> modifyPersonDetails(@RequestBody PersonDTO personDTO){
		PersonDTO updatedPersonDetails = personService.updatePersonDetails(personDTO);
		return new ResponseEntity<PersonDTO>(updatedPersonDetails,HttpStatus.OK);		
	}
	
	@PatchMapping(value="/{personId}/{newLocation}",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
													produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updatePersonLocationDetails(@PathVariable("personId") Integer personId,
														 @PathVariable("newLocation") String newLocation){
		PersonDTO updatedPersonDetails = personService.updatePersonLocationDetails(personId, newLocation);
		return new ResponseEntity<PersonDTO>(updatedPersonDetails,HttpStatus.OK);
	}
	
	@DeleteMapping("/{personId}")
	public ResponseEntity<String> deletePersonDetails(@PathVariable("personId") Integer personId) {
		String deleteStatus = personService.deletePersonDetailsById(personId);
		return new ResponseEntity<String>(deleteStatus, HttpStatus.OK);
	}
	
	//Rest API Method for Uploading image
	@PostMapping("/upload")
	public ResponseEntity<String> uploadProfileImage(@RequestParam("profileImage") MultipartFile multipartImage) throws Exception {
		String renamedFileName = personService.uploadProfilePicture(imageLocation, multipartImage);
		return new ResponseEntity<String>(renamedFileName, HttpStatus.OK);
	}
	
	//Controller level Exception Handler
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlingResourceNotFoundException(ResourceNotFoundException rnfe){
		ErrorDetails errorDetails = ErrorDetails.builder().errorTime(LocalDateTime.now())
														  .errorMessage(rnfe.getMessage()) //Person not found with personId : 1256
														  .errorStatus("Resource Not Found.....")
														  .build();
				
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
