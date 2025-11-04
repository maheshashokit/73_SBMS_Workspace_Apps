package com.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ashokit_persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
	
	@Id
	@Column(name="person_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="person_name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="created_dt")
	@Temporal(TemporalType.DATE)
	private LocalDate createdDate;

}
