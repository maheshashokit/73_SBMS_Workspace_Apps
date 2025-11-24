package com.ashokit.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

	private Integer id;
	
	private String doorNo;
	
	private String cityName;
	
	private String pincode;
	
	private LocalDateTime created_dt;
	
	private LocalDateTime updated_dt;
	
	private Integer customerId;

}
