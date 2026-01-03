package com.ashokit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void authManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("select username,password,enabled from users where username=?")
			.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(req) -> req
				   .requestMatchers("/","/v1/api/products/version").permitAll()
                   .requestMatchers("/dashboard","/v1/api/products/**").authenticated()
			       .requestMatchers("/rewards").hasRole("CUSTOMER")
			       .requestMatchers("/depoist").hasAnyRole("MANAGER","CLERK")
			       .anyRequest().authenticated() //remaining all requests should be authenticate
			      )
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.exceptionHandling(exceptionHandling ->{
					exceptionHandling.accessDeniedPage("/accessDenied");
				});
		return http.build();
	}
}