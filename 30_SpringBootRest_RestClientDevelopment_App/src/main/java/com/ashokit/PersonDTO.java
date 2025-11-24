package com.ashokit;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value=Include.NON_NULL)
public class PersonDTO {
	
	private Integer id;
	
	private String name;

	private String location;
	
	private String emailId;
	
	private String address;
	
	@JsonDeserialize(using=CustomDateDeserializer.class)
	private LocalDate createdDate;
	
	public PersonDTO(String name,String location,String emailId,String address) {
		this.name = name;
		this.location = location;
		this.emailId = emailId;
		this.address = address;
	}
}
