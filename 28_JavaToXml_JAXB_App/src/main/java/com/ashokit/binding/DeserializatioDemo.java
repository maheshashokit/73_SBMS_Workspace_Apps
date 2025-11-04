package com.ashokit.binding;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializatioDemo {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		//Creating ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		
		//Deserialize the Root Element
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		
		//Reading the json data from file
		Employee emp = mapper.readValue(new File("maheshit_employee.json"),Employee.class);
		
		//printing the emp Object
		System.out.println(emp);
	}

}
