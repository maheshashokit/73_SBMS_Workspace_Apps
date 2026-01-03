package com.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomePage(){
		 return new ResponseEntity<String>("Welcome To Ashok IT For Welcome Page.....",HttpStatus.OK);
	}
	
	@GetMapping("/contact")
	public ResponseEntity<String> getContactDetails(){
		 return new ResponseEntity<String>("Welcome To Ashok IT For Contact Page.....",HttpStatus.OK);
	}
}