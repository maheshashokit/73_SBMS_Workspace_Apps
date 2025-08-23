package com.ashokit;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashokit.controller.UserController;
import com.ashokit.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication application = new SpringApplication(Application.class);
		//application.setBannerMode(Banner.Mode.OFF);
		ConfigurableApplicationContext context = application.run(args);
		
		//Requesting spring bean objects from container
		UserController userController = context.getBean(UserController.class);
		System.out.println(userController);
		
		UserService userService = context.getBean(UserService.class);
		System.out.println(userService);
	}

}
