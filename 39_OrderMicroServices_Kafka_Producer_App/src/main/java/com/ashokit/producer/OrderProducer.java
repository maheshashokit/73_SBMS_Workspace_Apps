package com.ashokit.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.ashokit.events.OrderEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderProducer {
	
	@Autowired
	private NewTopic topic;

	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	public String sendMessage(OrderEvent orderEvent) {
		log.info("*******OrderEvent Started************");
		log.info(String.format("OrderEvent Data.....%s", orderEvent.toString()));
		
		//Preparing  message to send for KafkaBroker
		Message<OrderEvent> kafkaMessage = MessageBuilder
				.withPayload(orderEvent)//setting the payload of OrderEvent
				.setHeader(KafkaHeaders.TOPIC, topic.name()) //setting the topic name
				.build();
		try {
			//Sending message to KafkaBroker
			kafkaTemplate.send(kafkaMessage);//sending the message to kafka system
			log.info("*******OrderEvent Completed************");
			return "Order Placed Successfully...."+orderEvent.getOrder().getOrderId();
		}catch(Exception e) {
			e.printStackTrace();
			return "Problem Occurred While Placing Order....";
		}
	}
}
