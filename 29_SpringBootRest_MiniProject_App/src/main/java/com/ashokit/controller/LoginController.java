package com.ashokit.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.exceptions.ErrorDetails;
import com.ashokit.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@GetMapping("/")
	public ResponseEntity<String> getLoginMessage(){
		return new ResponseEntity<String>("Welcome To AshokIT",HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<String> getLoginMessage(@PathVariable("username") String username){
		return new ResponseEntity<String>("Welcome To AshokIT "+username,HttpStatus.OK);
	}
	
	@GetMapping("/{username}/{password}")
	public ResponseEntity<String> getLoginMessage(@PathVariable("username") String username,
												  @PathVariable("password") String password){
		
		return new ResponseEntity<String>(String.format("Welcome To AshokIT %s %s",username, password),HttpStatus.OK);
	}
	
	//Controller level Exception Handler
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlingResourceNotFoundException(ResourceNotFoundException rnfe){
		ErrorDetails errorDetails = ErrorDetails.builder().errorTime(LocalDateTime.now())
														  .errorMessage(rnfe.getMessage())
														  .errorStatus("Resource Not Found.....")
														  .build();
				
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}

}
