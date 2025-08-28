package com.ashokit.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfiguration {
	
	public DevConfiguration(){
		System.out.println("DevelopmentConfig Class Constructor....");
	}
}