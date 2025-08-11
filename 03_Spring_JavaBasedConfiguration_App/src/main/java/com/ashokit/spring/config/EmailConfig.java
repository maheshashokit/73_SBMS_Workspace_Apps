package com.ashokit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashokit.spring.beans.Address;

@Configuration
public class EmailConfig {

	 @Bean
	 public Address getAddressObject() {
		 Address address = new Address();
		 address.setCityName("Hyderabad");
		 address.setDoorNo("1-2-3");
		 address.setPincode("123455");
		 return address;
	 }
}
