package com.multiple.datasource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.multiple.datasource.entity.orders.OrderDetails;
import com.multiple.datasource.entity.payment.PaymentDetails;
import com.multiple.datasource.repository.order.OrderRepository;
import com.multiple.datasource.repository.payment.PaymentRepository;

@SpringBootApplication
public class SpringMultipleDatasoureApplication implements CommandLineRunner{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMultipleDatasoureApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//Creating OrderDetails object in oracle database
		Optional<OrderDetails> orderDetails = orderRepository.findById(2952l);
		if(orderDetails.isPresent()) {
			OrderDetails od = orderDetails.get();
			od.setPrice("6000");
			OrderDetails updatedOrder = orderRepository.save(od);
			System.out.println(updatedOrder);
		}else {
			OrderDetails od = new OrderDetails();
			//od.setId(1002);
			od.setPrice("5000");
			od.setQuantity("50");
			od.setCreated(new java.util.Date());
			od.setUpdated(new java.util.Date());
			OrderDetails savedOrder = orderRepository.save(od);
			System.out.println("SavedOrder:::::" + savedOrder);
		}
		
		//Creating PaymentDetails object in mysql database
		PaymentDetails pd = new PaymentDetails();
		pd.setId(123);
		pd.setCardName("Mahesh");
		pd.setCardNumber("123456");
		pd.setCvv("123");
		pd.setExpiry("01/23");
		PaymentDetails savedPayment = paymentRepository.save(pd);
		System.out.println("Saved Payment::::" + savedPayment);
	}
}