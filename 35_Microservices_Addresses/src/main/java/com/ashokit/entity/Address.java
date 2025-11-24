package com.ashokit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="shopping_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="door_no")
	private String doorNo;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="created_dt",updatable = false)
	@CreationTimestamp
	private LocalDateTime created_dt;
	
	@Column(name="updated_dt",insertable = false)
	@UpdateTimestamp
	private LocalDateTime updated_dt;
	
	@Column(name="customer_id")
	private Integer customerId;

}
