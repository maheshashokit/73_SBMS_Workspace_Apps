package com.ashokit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashokit.spring.beans.Demo;

@Configuration
public class DatabaseConfig {

	@Bean
	public Demo getDemoObject() {
		return new Demo();
	}
}
