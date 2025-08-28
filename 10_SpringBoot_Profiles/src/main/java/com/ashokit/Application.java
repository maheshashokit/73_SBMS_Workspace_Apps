package com.ashokit;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Date dataBean = context.getBean(Date.class);
		System.out.println(dataBean);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] activeProfiles = environment.getActiveProfiles();
		System.out.println("Active Profile-- "+ Arrays.asList(activeProfiles));
	    System.out.println("Database username:::" +  environment.getProperty("database.username"));
	    System.out.println("Database Password:::" +  environment.getProperty("database.password"));
	    System.out.println("Application Emails:::" +  environment.getProperty("application.emails"));
	}
}
