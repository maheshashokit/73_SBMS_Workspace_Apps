package com.ashokit.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ashokit.dto.Order;
import com.ashokit.events.OrderEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumer {
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", 
				   groupId = "${spring.kafka.consumer.group-id}",
				   containerFactory="kafkaListnerFactory")
	public void orderReceivedDetails(OrderEvent orderEvent) {
		log.info("Test::::", orderEvent);
		Order order = orderEvent.getOrder();
		System.out.println("Tested Order:::::" + order.toString());
		//save the data into database for processing order if its saved try to push some
		//another message into another topic of kafka....
	}
}
