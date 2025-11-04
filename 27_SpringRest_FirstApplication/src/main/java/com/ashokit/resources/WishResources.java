package com.ashokit.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/wishes")
public class WishResources {
	
	//Developing GET Rest API for sending wishes
	@GetMapping(value = "/")
	public ResponseEntity<String> getWishes(){
		String wishMessage ="Welcome To AshokIT For Rest API Development"+ new java.util.Date();
		return new ResponseEntity<String>(wishMessage,HttpStatus.OK);
	}
}