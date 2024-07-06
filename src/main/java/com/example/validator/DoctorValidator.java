package com.example.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.util.PasswordUtil;
import com.example.controlleradvice.ObjectInvalidException;
import com.example.dto.DoctorDto;
import com.example.entity.Doctor;
import com.example.enumeration.RequestType;
import com.example.repository.DoctorRepository;
import com.example.service.DoctorService;
import com.example.service.MessagePropertyService;
import com.example.util.ValidationUtil;
import com.google.common.base.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = { @Autowired })
public class DoctorValidator {

	@Autowired
	MessagePropertyService messageService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private DoctorRepository doctorRepository;

	List<String> errors = null;
	List<String> errorsObj = null;
	Optional<Subject> subject = null;

	public ValidationResult validate(RequestType requestType, DoctorDto requestDto) {
		errors = new ArrayList<>();

		Doctor doctorObj = null;

		if (requestType.equals(RequestType.POST)) {
			if (!ValidationUtil.isNull(requestDto.getDoctorId())) {
				throw new ObjectInvalidException(messageService.getMessage("invalid.request.payload"));
			}

			Optional<Doctor> doctorOptional = doctorService.getByPhoneNo(requestDto.getPhoneNo());
			if (doctorOptional.isPresent()) {
				String[] params = new String[] { requestDto.getPhoneNo() };
				errors.add(messageService.getMessage("doctor.phone.no.dublicate", params));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getFirstName())) {
				errors.add(messageService.getMessage("doctor.first.name.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getLastName())) {
				errors.add(messageService.getMessage("doctor.last.name.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getEmailId())) {
				errors.add(messageService.getMessage("email.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getPassword())) {
				errors.add(messageService.getMessage("password.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getDesignation())) {
				errors.add(messageService.getMessage("designation.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getDepartment())) {
				errors.add(messageService.getMessage("department.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getMobileNumber())) {
				errors.add(messageService.getMessage("mobileNumber.required"));
			}
			if (ValidationUtil.isNullorEmpty(requestDto.getDoctorNo())) {
				errors.add(messageService.getMessage("Doctor no .required"));
			}
		} else {
			if (ValidationUtil.isNull(requestDto.getDoctorId())) {
				throw new ObjectInvalidException(messageService.getMessage("invalid. request.payload"));
			}
			Optional<Doctor> doctorOptional = doctorRepository.findById(requestDto.getDoctorId());

			if (!doctorOptional.isPresent()) {
				throw new ObjectInvalidException(messageService.getMessage("doctor.not.found"));
			}
			doctorObj = doctorOptional.get();
		}
		ValidationResult result = new ValidationResult();

		if (errors.size() > 0) {
			String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
			throw new ObjectInvalidException(errorMessage);
		}
		if (null == doctorObj) {
			doctorObj = Doctor.builder().firstName(requestDto.getFirstName()).lastName(requestDto.getLastName())
					.emailId(requestDto.getEmailId()).password(PasswordUtil.getEncryptedPassword(requestDto.getPassword()))
					.designation(requestDto.getDesignation()).department(requestDto.getDepartment())
					.phoneNo(requestDto.getPhoneNo()).mobileNumber(requestDto.getMobileNumber()).build();
		} else {
			doctorObj.setDoctorNo(requestDto.getDoctorNo());
			doctorObj.setFirstName(requestDto.getFirstName());
			doctorObj.setLastName(requestDto.getLastName());
			doctorObj.setMobileNumber(requestDto.getMobileNumber());
			doctorObj.setPhoneNo(requestDto.getPhoneNo());
			doctorObj.setEmailId(requestDto.getEmailId());
			doctorObj.setDepartment(requestDto.getDepartment());
			doctorObj.setDesignation(requestDto.getDesignation());
		}
		result.setObject(doctorObj);
		return result;
	}
}