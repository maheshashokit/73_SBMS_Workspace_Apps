/*package com.ashokit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private DataSource ds;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();  //Indicates NoPassword Encoding
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     //This method is used for Jdbc Authentication
	     auth.jdbcAuthentication().dataSource(ds).passwordEncoder(getPasswordEncoder())
	    .usersByUsernameQuery("select username,pwd,user_status from application_users where username=?")
	    .authoritiesByUsernameQuery("select username,role_name from application_roles where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll()
		                        .antMatchers("/dashboard").authenticated()
		                        .antMatchers("/rewards").hasAuthority("CUSTOMER")
		                        .antMatchers("/depoist").hasAnyAuthority("MANAGER","CLERK")
		                        .anyRequest().authenticated() //remaining all requests should be authenticate
		                        .and()
		                        .httpBasic() //For Testing REST API THROUGH POSTMAN
		                        .and()
		                        .formLogin()
		                        .and()
		                        .exceptionHandling()
		                        .accessDeniedPage("/accessDenied");
	}
}*/