package com.ashokit.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	ModelMapper getModelMapper() {
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}

	/*@Bean
	Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}*/

}