package com.example.dto;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class DoctorDto {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID doctorId;
	
	private String doctorNo;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String designation;
	
	private String department;
	
	private String mobileNumber;
	

}
