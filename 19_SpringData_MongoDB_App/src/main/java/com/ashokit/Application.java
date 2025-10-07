package com.ashokit;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashokit.dao.CustomerDao;
import com.ashokit.dao.EmployeeDao;
import com.ashokit.entity.Customer;
import com.ashokit.entity.Employee;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private CustomerDao customerDao;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		//creating Employee Object
		/*Employee emp = new Employee();
		//setting id property value explictly
		System.out.println("UUID.randomUUID().toString()" + UUID.randomUUID().toString());
		emp.setId(UUID.randomUUID().toString());
		emp.setName("Ramesh");
		emp.setDesignation("Senior Tech");
		emp.setContactNo("123456789");
		emp.setEmailIds(new String[]{"ramesh.ashokit@gmail.com"});
		
		//saving the emp object information
		Employee savedEmployee = employeeDao.save(emp);
		
		//displaying the saved employee
		System.out.println("Employee Record got Created:::::" + savedEmployee);*/
		
        System.out.println("************************************");
		Optional<Employee> employeeOpt = employeeDao.findByNameAndDesignation("Ramesh", "Senior Tech");
		if(employeeOpt.isPresent()) {
			System.out.println(employeeOpt.get());
		}else {
			System.out.println("Employee Not Found....");
		}
		System.out.println("************************************");
		List<Employee> allEmployees = employeeDao.getAllEmployeesByDesignation("Senior Tech");
		allEmployees.forEach(System.out::println);	
		
	}
}
