package com.ashokit.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;

	private String fieldName;

	private long fieldValue;
	
	private String errorInfo;

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	// parameterized Constructor
	public ResourceNotFoundException(String resourceName, String fieldName) {
		// Person not found with personId
		super(String.format("%s not found with Given %s ", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}

	// parameterized Constructor
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		// Person not found with personId : 1256
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	// parameterized Constructor
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue, String errorInfo) {
		// Person not found with personId : 1256
		super(String.format("%s not found with %s : %s....%s", resourceName, fieldName, fieldValue,errorInfo));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.errorInfo = errorInfo;
	}
}