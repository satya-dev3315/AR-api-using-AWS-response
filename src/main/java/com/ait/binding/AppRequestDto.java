package com.ait.binding;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppRequestDto {

	//send req to ssa web api in cloud using these attributes.SSA request class also consist same attributes
	
    private Integer appNumber;
	
	private String fullName;
	
	private Long ssn;
	
	private LocalDate dob;
	
	private String gender;
	
	private Integer planId;    
	
	private Integer citizenId;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;
}
