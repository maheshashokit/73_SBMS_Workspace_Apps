package com.ashokit.binding;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MarshallingClient {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		//Creating some Orders objects
		Order o1 = new Order("OD123",25000);
		Order o2 = new Order("OD456",35000);
		Order o3 = new Order("OD789",45000);
		
		//Creating the customer Object
		Customer cust = new Customer(123,"Ashok","Hyderabad",Arrays.asList(o1,o2,o3));
		
		//Creating the JAXBContext Object for Customer Class
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		
		//Getting the Marshaller Object
		Marshaller marshallerObj = context.createMarshaller();
		
		//formatting purpose
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		 
		//performing the Marshalling
		marshallerObj.marshal(cust, System.out);
		marshallerObj.marshal(cust, new FileOutputStream("customer.xml"));
	}
}
