package com.ashokit.client;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.ashokit.beans.Course;
import com.ashokit.beans.Demo;
import com.ashokit.beans.Student;
import com.ashokit.beans.Welcome;

public class SpringClient {

	public static void main(String[] args) {
		
		//Activating the Spring container
		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
	
		//Reading the spring configuration file
		XmlBeanDefinitionReader xdr = new XmlBeanDefinitionReader(context);
		xdr.loadBeanDefinitions("spring.xml");
		
		//Requesting the spring bean object from spring container by using class name
		Welcome welcome = context.getBean(Welcome.class);
		welcome.displayData();
		
		//Requesting the spring bean object from spring container by using id attribute
		Demo  demoBean = (Demo)context.getBean("demoBean");
		demoBean.showData();
		
		Student student = context.getBean(Student.class);
		System.out.println(student);
		student.displayStudentDetails();
		
		Course course = (Course) context.getBean("course");
		System.out.println(course);
		
	}
}