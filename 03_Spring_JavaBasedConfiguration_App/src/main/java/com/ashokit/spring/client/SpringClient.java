package com.ashokit.spring.client;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashokit.spring.beans.Address;
import com.ashokit.spring.beans.Course;
import com.ashokit.spring.beans.Demo;
import com.ashokit.spring.beans.Student;
import com.ashokit.spring.beans.User;
import com.ashokit.spring.config.AppConfig;

public class SpringClient {

	public static void main(String[] args) {
		
		//Creating container object and passing java based configuration class
		//ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class,EmailConfig.class,DatabaseConfig.class);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Requesting the object from spring container
		User user = context.getBean(User.class);
		System.out.println(user);
		System.out.println(user.getUserDetails());
		
		Student student = context.getBean(Student.class);
		Student student1 = context.getBean(Student.class);
		Student student11 = context.getBean(Student.class);
		System.out.println(student.hashCode());
		System.out.println(student1.hashCode());
		System.out.println(student11.hashCode());
		
		Course course = context.getBean(Course.class);
		Course course1 = context.getBean(Course.class);
		Course course11 = context.getBean(Course.class);
		System.out.println(course.hashCode());	
		System.out.println(course1.hashCode());	
		System.out.println(course11.hashCode());	
		
		Demo demo = context.getBean(Demo.class);
		System.out.println(demo);
		
		Address address = context.getBean(Address.class);
		System.out.println(address);
		
		Date currentDate = context.getBean(Date.class);
		System.out.println(currentDate);
		
	}
}
