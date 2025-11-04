package com.ashokit;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Person Rest API Development", 
								version = "1.0.0",
                                description = "AshokIT Developed Person Rest API",
                                termsOfService = "All Rights are Reserved....",
                                contact = @Contact(name="Mahesh",email="mahesh.ashokit@gmail.com"),
                                license = @License(name="License",url = "www.ashokit.in")
				   ))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//Making ModelMapper as SpringBean
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}