package com.ashokit.response;

import java.util.List;

import com.ashokit.dto.PersonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PageResponse {
	
	//Holding page specific records
	private List<PersonDTO> content;
	
	private int pageNumber;
	
	private int pageSize;
	
	private long totalElements;
	
	private long totalPages;
	
	//If current page is lastPage means will return true otherwise will return false
	private boolean lastPage;
}