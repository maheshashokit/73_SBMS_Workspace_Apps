package com.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ashokit.spring.beans.Customer;
import com.ashokit.spring.beans.DatabaseBean;
import com.ashokit.spring.beans.Employee;

@SpringBootApplication
@PropertySource(value = "custom.properties")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Customer customer = context.getBean(Customer.class);
		System.out.println(customer);
		
		Employee emp =context.getBean(Employee.class);
		System.out.println(emp);
		
		DatabaseBean dbBean = context.getBean(DatabaseBean.class);
		System.out.println(dbBean);
	}

}
