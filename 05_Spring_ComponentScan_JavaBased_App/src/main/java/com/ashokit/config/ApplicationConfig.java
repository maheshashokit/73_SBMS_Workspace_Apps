package com.ashokit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//Enabling the component scan for java based configuration
@ComponentScan(basePackages = "com.ashokit")
public class ApplicationConfig {

}
