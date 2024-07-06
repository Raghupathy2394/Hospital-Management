package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;
import com.google.common.base.Optional;

@Service
@Transactional
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public Optional<Doctor> getByPhoneNo(String phoneNo) {
		return doctorRepository.findByPhoneNo(phoneNo);
	}
	
	
}
