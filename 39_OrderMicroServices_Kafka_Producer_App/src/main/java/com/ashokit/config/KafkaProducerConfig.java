package com.ashokit.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ashokit.events.OrderEvent;

@Configuration
public class KafkaProducerConfig {
	
	//collecting the topic name from application.properties file
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	//Defining the Spring bean definition for creating topic through programmatic approach
	@Bean
	public NewTopic creatingNewTopic() {
		//Creating the new topic in kafka broker with 1 partition by default
		return TopicBuilder.name(topicName).build();
	}
	
	@Bean
	public ProducerFactory<String, OrderEvent> producerFactory() {
		
		//creating map object for storing kafka configurations
		Map<String, Object> configProps = new HashMap<>();
		
		//specifying the location for kafka broker
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		//specifying the serialization for key while publishing message to kafka broker
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		//specifying the serialization for value while publishing message to kafka broker
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, OrderEvent> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
