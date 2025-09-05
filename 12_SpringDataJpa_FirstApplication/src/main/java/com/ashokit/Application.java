package com.ashokit;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashokit.controller.CustomerController;
import com.ashokit.dao.BikeDao;
import com.ashokit.dao.EmployeeDao;
import com.ashokit.dao.ProductDao;
import com.ashokit.dao.VehicleDao;
import com.ashokit.entity.Bike;
import com.ashokit.entity.Customer;
import com.ashokit.entity.Employee;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private BikeDao bikeDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Customer customer = new Customer("Mahesh", "Hyderabad", "mahesh.ashokit@gmail.com", "1232323232");

		CustomerController controller = context.getBean(CustomerController.class);
		//controller.createNewCustomer(customer);
		
		
		//New Customer Information
		Customer customer1 = new Customer("Mahesh","Hyderabad","mahesh1.ashokit@gmail.com","123456789");
		Customer customer2 = new Customer("Suresh","Pune","suresh.ashokit@gmail.com","545454454");
		Customer customer3 = new Customer("Rajesh","Chennai","rajesh.ashokit@gmail.com","23323232");
		Customer customer4 = new Customer("Ramesh","Hyderabad","ramesh.ashokit@gmail.com","121212121");
		
		//controller.createBulkNewCustomers(List.of(customer1,customer2,customer3,customer4));
		//controller.fetchCustomerDetailsById(1240);
				
		//controller.fetchAllCustomersDetails();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		/*Product p = new Product();
		p.setProductName("Laptop");
		p.setProductPrice(50000.00f);
		
		Product p1 =new Product();
		p1.setProductName("Mobilephone");
		p1.setProductPrice(10000.00f);
		
		Iterable<Product> savedProducts = productDao.saveAll(Arrays.asList(p,p1));
		savedProducts.forEach(prod -> System.out.println(prod));   
		
		System.out.println("*****************************************************************");
		
		Vehicle  v1 = new Vehicle();
		v1.setVehicleName("Tata");
		v1.setVehicleCost(50000.00f);
		
		Vehicle v2 = new Vehicle();
		v2.setVehicleName("Hyundai");
		v2.setVehicleCost(60000.00f);
		
		Iterable<Vehicle> savedVehicles = vehicleDao.saveAll(Arrays.asList(v1,v2));
		savedVehicles.forEach(veh  -> System.out.println(veh));*/
		
		Bike b1 = new Bike();
		b1.setBikeName("Access");
		b1.setCost(100000);
		
		Bike b2 = new Bike();
		b2.setBikeName("Activa");
		b2.setCost(200000);
		
		Iterable<Bike> savedBikes = bikeDao.saveAll(Arrays.asList(b1,b2));
		savedBikes.forEach(bike -> System.out.println(bike));	
		
		
		Employee e1 = new Employee();
		e1.setEmployeeName("Mahesh");
		
		Employee e2 = new Employee();
		e2.setEmployeeName("Rajesh");
		
		Iterable<Employee> savedEmployee = employeeDao.saveAll(Arrays.asList(e1,e2));
		savedEmployee.forEach(emp-> System.out.println(emp));	
		
	}
}
