package com.ashokit.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorDetails {
	
	private LocalDateTime errorTime;
	
	private String errorMessage;
	
	private String errorStatus;
	
}
