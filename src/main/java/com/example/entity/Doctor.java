package com.example.entity;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@Table
@Entity
public class Doctor {
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID doctorId;

	@Column(name = "doctor_no")
	private String doctorNo;

	@NotBlank(message = "password cannot be blank")
	@Column(name = "password")
	private String password;

	@NotBlank(message = "First name cannot be blank")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Last name cannot be blank")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Email cannot be blank")
	@Column(name = "email_id")
	private String emailId;

	@NotBlank(message = "designation cannot be blank")
	@Column(name = "designation")
	private String designation;

	@NotBlank(message = "department cannot be blank")
	@Column(name = "department")
	private String department;

	@NotBlank(message = "Mobile number cannot be blank")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@NotBlank(message = "Phone number cannot be blank")
	@Column(name = "phone_no")
	private String phoneNo;
}
