package com.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wishes")
public class WishController {
	
	@GetMapping("/")
	public ResponseEntity<String> getWishMessage(){
		return new ResponseEntity<String>("Welcome To AshokIT",HttpStatus.OK);
	}

}
