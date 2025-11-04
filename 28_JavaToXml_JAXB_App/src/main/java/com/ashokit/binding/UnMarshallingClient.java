package com.ashokit.binding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshallingClient {
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		//Creating JAXBContext Object
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		
		//creating UnMarshaller Object
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		//UnMarshal the object
		Customer customer = (Customer) unmarshaller.unmarshal(new FileInputStream("maheshit_customers.xml"));
		
		//printing the Customer Object
		System.out.println(customer);
		System.out.println(customer.getOrder());
		
	}

}
