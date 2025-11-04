package com.ashokit.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Global Exception Handling (or) Application level Exception Handling
@RestControllerAdvice  // Spring Rest
//@ControllerAdvice //spring mvc
public class ApplicationErrorHandling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlingResourceNotFoundException(ResourceNotFoundException rnfe){
		ErrorDetails errorDetails = ErrorDetails.builder().errorTime(LocalDateTime.now())
														  .errorMessage(rnfe.getMessage())
														  .errorStatus("Resource Not Found.....")
														  .build();
				
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handlingException(Exception e){
		ErrorDetails errorDetails = ErrorDetails.builder().errorTime(LocalDateTime.now())
														  .errorMessage(e.getMessage())
														  .errorStatus("Problem Occured while Executing Resource")
														  .build();
				
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
