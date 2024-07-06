package com.example.controller;

import javax.validation.constraints.NotBlank;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DoctorDto;
import com.example.response.ResponseGenerator;
import com.example.response.TransactionContext;
import com.example.service.MessagePropertyService;
import com.example.validator.ValidationResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;

@CrossOrigin(origins= "*", maxAge = 3600)
@RestController
@RequestMapping("/api/adminController")
@Api(value = "AdminController Rest API", produces = "application/json", consumes = "application/json")
public class AdminController {

	private static final Logger logger=Logger.getLogger(AdminController.class);
	private @NonNull ResponseGenerator responseGenerator;
	
	private @NonNull MessagePropertyService messageSource;
	
//	@PostMapping(value = "/create", produces = "application/json")
//public ResponseEntity<?> create(@ApiParam(value = "The Admin Controller request payload") @RequestBody DoctorDto request, @RequestHeader HttpHeaders httpHeaders) {
//		TransactionContext context = responseGenerator.genereateTransactionContext(httpHeaders);
//	//	ValidationResult validationResult = validatorService.validate(RequestType.POST, request);
//	}
}























