package com.ashokit.binding;

import java.io.File;
import java.util.Arrays;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class XMLClient {
	
	public static void main(String[] args) throws JAXBException {		
		
		//creating java object for order data
		Order order = new Order("345",2500d); 
		Order order1 = new Order("645",3500d); 
		 
		//creating java object for customer data
	    Customer customer = new Customer(123,"Mahesh","Hyderabad", Arrays.asList(order,order1));			
				
		//creating the JAXBContext
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		
		//creating marshal object
		Marshaller marshalObj = context.createMarshaller();
		
		//output formatting
		marshalObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		//performing marshalling operation
		marshalObj.marshal(customer, new File("maheshit_customers.xml"));
		
	}

}
