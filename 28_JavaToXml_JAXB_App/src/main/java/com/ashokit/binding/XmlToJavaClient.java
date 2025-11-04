package com.ashokit.binding;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class XmlToJavaClient {

	public static void main(String[] args) throws JAXBException {

		// create JaxBContext object
		JAXBContext context = JAXBContext.newInstance(Customer.class);

		// Creating Unmarshaller Object
		Unmarshaller unmarshaller = context.createUnmarshaller();

		Customer customer = (Customer) unmarshaller.unmarshal(new File("maheshit_customers.xml"));

		// Displaying the customer information
		System.out.println("Customer::::" + customer);
	}

}
