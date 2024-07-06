package com.example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Doctor;

public interface DoctorRepository extends WriteableRepository<Doctor, UUID> {

}
