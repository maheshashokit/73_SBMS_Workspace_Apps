package com.ashokit;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		/*SpringApplication app = new SpringApplication(Application.class);
		app.setAdditionalProfiles("uat");
		app.run(args);*/
		SpringApplication.run(Application.class);		
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Active Profile Name ::::" + Arrays.toString(environment.getActiveProfiles()));
		System.out.println("Database UserName::: " + environment.getProperty("database.username"));
		System.out.println("Database Password::: " + environment.getProperty("database.password"));
		System.out.println("Application Emails::: " + environment.getProperty("application.emails"));
	}

}
