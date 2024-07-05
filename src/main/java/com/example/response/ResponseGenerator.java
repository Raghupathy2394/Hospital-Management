package com.example.response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ResponseGenerator {

	private static final Logger logger = Logger.getLogger(ResponseGenerator.class);

	public ResponseEntity<Response> successResponse(TransactionContext context, Object object, HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("correlationId", context.getCorrelationId());
		headers.add("applicationLabel", context.getApplicationLabel());
		headers.add("content-Type", "application/json");
		Response response = new Response();
		response.setData(object);
		response.setTimeStamp(new SimpleDateFormat("YYYY.mm.dd.HH.mm.ss").format(new Date()));
		logger.debug("response class is " + Data.class);
		logger.debug("response status is " + httpStatus.toString());
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers, httpStatus);
		return responseEntity;

	}

	public ResponseEntity<Response> successGetResponse(TransactionContext context, String message, Object object,
			HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("correlationId", context.getCorrelationId());
		headers.add("applicationLabel", context.getApplicationLabel());
		headers.add("content-Type", "application/json");
		Response response = new Response();
		response.setData(object);
		response.setMessage(message);
		response.setTimeStamp(new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date()));
		logger.debug("response class is " + Data.class);
		logger.debug("response status is " + httpStatus.toString());
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers, httpStatus);
		return responseEntity;
	}

	public ResponseEntity<Response> errorResponse(TransactionContext context, String errorMessage,
			HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("correlationId", context.getCorrelationId());
		headers.add("ApplicationLabel", context.getApplicationLabel());
		headers.add("content-Type", "application/json");
		Error error = new Error();
		error.setCode(httpStatus.toString() + "0001");
		error.setReason(errorMessage);
		Response response = new Response();
		response.setError(error);
		response.setTimeStamp(new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date()));
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers, httpStatus);
		return responseEntity;
	}

	public TransactionContext genereateTransactionContext(HttpHeaders httpHeaders) {
		TransactionContext context = new TransactionContext();

		if (null == httpHeaders) {
			context.setCorrelationId("demo");
			context.setApplicationLabel("demo");
			return context;
		}
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLable") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}
		return context;
	}
  
	public ResponseEntity<?> errorResponse(Map<String, Object> response, HttpStatus badRequest){
		return null;
	}
}
