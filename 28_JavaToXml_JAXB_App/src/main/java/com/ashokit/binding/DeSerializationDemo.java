package com.ashokit.binding;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeSerializationDemo {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		//Creating ObjectMapper Object
		ObjectMapper mapper = new ObjectMapper();
		
		//Deserializing the Root Element
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		
		Employee emp = mapper.readValue(new File("maheshit_employee.json"), Employee.class);
		
		System.out.println(emp);
	}
}
