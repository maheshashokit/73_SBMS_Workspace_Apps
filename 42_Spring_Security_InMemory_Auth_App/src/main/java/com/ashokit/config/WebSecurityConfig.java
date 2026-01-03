package com.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
		
	//This bean is used for defining the Authentication related information
	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		  
		UserDetails user1 = User.withUsername("Mahesh").password(getPasswordEncoder().encode("Mahesh@123")).roles("ADMIN","MANAGER").build();
		UserDetails user2 = User.withUsername("Ashok").password(getPasswordEncoder().encode("Ashok@123")).roles("CLERK","CUSTOMER","CASHIER").build();
		UserDetails user3 = User.withUsername("Suresh").password(getPasswordEncoder().encode("Suresh@123")).roles("CUSTOMER").build();
		
		return new InMemoryUserDetailsManager(user1,user2,user3);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}
	
	//This bean is used for defining the Authorization related information
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http.authorizeHttpRequests(
				(req) -> req
				   .requestMatchers("/","/v1/api/products/version").permitAll() //No Authentication & Authorization
                   .requestMatchers("/dashboard","/v1/api/products/**").authenticated() // Requires authentication
			       .requestMatchers("/rewards").hasRole("CUSTOMER")
			       .requestMatchers("/depoist").hasAnyRole("MANAGER","CLERK")
			       .anyRequest().authenticated() //remaining all requests should be authenticate
			      )
				.httpBasic(Customizer.withDefaults()) //Applying the Security for postman testing
				.formLogin(Customizer.withDefaults()) //Applying the security for form handling
				.exceptionHandling(exception -> {
					exception.accessDeniedPage("/accessDenied");
				 });
		return http.build();
	}	
	
}