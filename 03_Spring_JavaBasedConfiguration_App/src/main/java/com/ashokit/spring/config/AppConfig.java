package com.ashokit.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.ashokit.spring.beans.Course;
import com.ashokit.spring.beans.Student;
import com.ashokit.spring.beans.User;

//Inheriting the configuration from DatabaseConfig,EmailConfig class
@Import(value= {EmailConfig.class,DatabaseConfig.class})

//Importing the spring bean definitions from xml file to configuration class
@ImportResource(value = "spring.xml")

//Recognizing the Reading properties file by the spring container
@PropertySource(value = "applicationConfig.properties")

//This will acts as Spring Configuration File
@Configuration
public class AppConfig {
	
	@Value("${user.username}")
	private String username;
	
	@Value("${user.password}")
	private String password;
	
	@Bean
	public User getUserObject() {
		User currentUser = new User();
		currentUser.setUsername(username);
		currentUser.setPassword(password);
		return currentUser;		
	}
	
	@Bean
	public Course getCourseObject() {
		Course course = new Course();
		course.setCourseName("SBMS");
		course.setCourseFee(8000);
		return course;
	}
	
	@Bean
	public Student getStudentObject() {
		Student student = new Student();
		student.setId("AIT123");
		student.setName("Mahesh");
		student.setEmailId("mahesh.ashokit@gmail.com");
		student.setCourse(getCourseObject());		
		return student;
	}
}