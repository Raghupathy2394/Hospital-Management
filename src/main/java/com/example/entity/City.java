package com.example.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "citys")
public class City {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	
	@Column(name="name")
	private String name;	

	@Column(name="short_dese")
	private String shortName;

	@Column(name = "zip_code")
	private String zipCode;



}

