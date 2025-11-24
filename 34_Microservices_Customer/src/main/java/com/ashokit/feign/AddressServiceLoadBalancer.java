/*package com.ashokit.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value="ADDRESS-SERVICE",configuration = CustomLoadBalancerConfig.class)
public class AddressServiceLoadBalancer {

    @LoadBalanced
    @Bean
    Feign.Builder feBuilder(){
		return Feign.builder();
	}
}*/