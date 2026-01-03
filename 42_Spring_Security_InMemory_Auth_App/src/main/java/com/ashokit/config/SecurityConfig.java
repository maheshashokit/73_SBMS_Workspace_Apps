/*package com.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder getNoOpPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();  //Indicates NoPassword Encoding
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//This method is used for Authentication
		auth.inMemoryAuthentication().withUser("Mahesh").password("$2a$10$05695p3RcsJ8higzLsbNme73lLjupcVP05wU3oI6voR4bJkMUvMT6").roles("ADMIN","MANAGER");
		auth.inMemoryAuthentication().withUser("Suresh").password("$2a$10$M4DGB2d4md3du3ewrwY2c.v20L7L/9E8BdnBisHEFtRGBLLCmneUe").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("Ashok").password("$2a$10$Xrx6wOkZ9wJlKdst9MhmoujA6ENhQTZgUIMQ8xgZCrGBRVwg5FI3.").roles("CUSTOMER","CLERK","CASHIER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/","/v1/api/products/version").permitAll()
		                        .antMatchers("/dashboard","/v1/api/products/**").authenticated()
		                        .antMatchers("/rewards").hasRole("CUSTOMER")
		                        .antMatchers("/depoist").hasAnyRole("MANAGER","CASHIER")
		                        .anyRequest().authenticated() //remaining all requests should be authenticate
		                        .and()
		                        .httpBasic() //For Testing REST API THROUGH POSTMAN / We can test Browser testing
		                        .and()
		                        .formLogin()//spring security provided login page.
		                        .and()
		                        .exceptionHandling()
		                        .accessDeniedPage("/accessDenied");
	}
}*/