package com.ashokit.binding;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SerializationdDemo {
	
	public static void main(String[] args) throws IOException {
		
		//Creating JobDetails Object
		JobDetails jd = new JobDetails();
		jd.setJobId("JD123");
		jd.setJobBand("A3");
		
		//Creating Address objects
		Address add1 = new Address("1-2-3","Hyderabad","Telegana","Permanent");
		Address add2 = new Address("3-2-1","Hyderabad","Telegana","Present");
		
		//creating the Employee Object
		Employee emp = new Employee(01,"Ashok","SoftwareEngineer",35000,new java.util.Date(),jd,Arrays.asList(add1,add2));
		
		//Performing the Serialization 
		ObjectMapper mapper = new ObjectMapper();		
		
		//JSON Root Element Configuration
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		//performing the serialization
		String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);		
		System.out.println(jsonData);
		
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(new File("maheshit_employee.json"), emp);
		System.out.println("Completed Creating File");
	}

}
