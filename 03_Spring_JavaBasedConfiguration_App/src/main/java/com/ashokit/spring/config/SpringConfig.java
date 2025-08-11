package com.ashokit.spring.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.ashokit.spring.beans.Demo;
import com.ashokit.spring.beans.User;

//Representating the Java class as spring configuration class
@Configuration

//Recognizing the Reading properties file by the spring container
@PropertySource(value = "applicationConfig.properties")

//Importing the one configuration class bean definition into another configuration class
@Import(value = {DatabaseConfig.class,EmailConfig.class})

//Importing the spring bean definitions from xml configuration file
@ImportResource(value = "spring.xml")

public class SpringConfig {
	
	//Reading property value from properties file
	@Value("${user.username}")
	private String username;
	
	@Value("${user.password}")
	private String password;

	//User class as spring Bean
	@Bean
	public User getUserObject() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
	@Bean
	public Demo getDemoObject() {		
		//return new Demo("Mahesh","Mahesh@123");
		return new Demo();
	}
	
	@Bean
	public Date getDateObject() {
		return new java.util.Date();
	}
}