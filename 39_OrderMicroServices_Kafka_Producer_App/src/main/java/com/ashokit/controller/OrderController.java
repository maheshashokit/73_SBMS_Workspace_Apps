package com.ashokit.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.dto.Order;
import com.ashokit.events.OrderEvent;
import com.ashokit.producer.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

     private OrderProducer orderProducer;
     
     //Constructor Injection
     public OrderController(OrderProducer orderProducer) {
    	 this.orderProducer = orderProducer;
     }
     
     @PostMapping("/createNewOrder")
     public ResponseEntity<?> placingOrder(@RequestBody Order order){

    	 //setting orderId for Order Payload
    	 order.setOrderId(UUID.randomUUID().toString());
    	 
    	 //Creating OrderEvent for sending
    	 OrderEvent orderEvent = new OrderEvent();
    	 orderEvent.setStatus("PENDING");
    	 orderEvent.setMessage("Order Status is in Pending....");
    	 orderEvent.setOrder(order);
    	 
    	 //calling Service Method
    	 return new ResponseEntity<String>(orderProducer.sendMessage(orderEvent),HttpStatus.CREATED);
     }
}
