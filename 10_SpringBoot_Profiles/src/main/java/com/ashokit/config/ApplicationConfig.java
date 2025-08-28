package com.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {
	
	@Bean
	@Profile("dev")
	public java.util.Date getCurrentDate() {
		return new java.util.Date();
	}

}
