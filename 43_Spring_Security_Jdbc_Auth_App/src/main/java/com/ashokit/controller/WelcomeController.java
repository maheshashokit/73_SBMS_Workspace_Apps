package com.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping(value="/dashboard")
	public ResponseEntity<String> getDashBoardPage(){
		return new ResponseEntity<String>("Welcome To Ashok IT Dashboard Page.....",HttpStatus.OK);
	}
	
	@GetMapping(value="/rewards")
	public ResponseEntity<String> getRewardsPage(){
		return new ResponseEntity<String>("Welcome To Ashok IT Rewards Page.....",HttpStatus.OK);
	}
	
	@GetMapping(value="/depoist")
	public ResponseEntity<String> getDepoistPage(){
		return new ResponseEntity<String>("Welcome To Ashok IT Depoist Page.....",HttpStatus.OK);
	}
	
	@GetMapping(value="/accessDenied")
	public ResponseEntity<String> getAccessDeniedPage(){
		return new ResponseEntity<String>("Sorry You Don't Have Access For this Page.....",HttpStatus.OK);
	}
}
