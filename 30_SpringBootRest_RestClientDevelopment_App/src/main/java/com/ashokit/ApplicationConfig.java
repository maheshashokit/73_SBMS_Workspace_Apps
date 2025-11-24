package com.ashokit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public RestTemplate getRestTemplateObject() {
		return new RestTemplate();
	}

}
