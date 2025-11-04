package com.ashokit.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/login")
public class LoginResources {
	
	@GetMapping("/")
	public ResponseEntity<String> getLoginStatus(@RequestParam("username") String username,
						                         @RequestParam("password") String password){
		//validating the login Credentials
		if(username != null && password != null) {			
			if("Mahesh".equalsIgnoreCase(username) && "Mahesh".equalsIgnoreCase(password)) {
				return new ResponseEntity<String>("Login Success....." ,HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Login Failure Due to either Username or Password are Incorrect....." ,HttpStatus.OK);
			}
		}else {
			return new ResponseEntity<String>("Username & Password Can't be Empty....." ,HttpStatus.OK);
		}
	}

}
