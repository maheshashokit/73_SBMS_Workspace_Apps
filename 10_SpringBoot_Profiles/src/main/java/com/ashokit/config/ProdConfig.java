package com.ashokit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {
	public ProdConfig() {
		System.out.println("ProdConfig Constructor.....");
	}
}
