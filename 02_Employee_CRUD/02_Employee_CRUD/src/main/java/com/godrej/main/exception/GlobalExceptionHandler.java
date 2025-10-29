package com.godrej.main.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<ObjectError> allErrors = ex.getAllErrors();
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for (ObjectError objectError : allErrors) {
			FieldError fieldError =(FieldError) objectError;
			String fieldName = fieldError.getField();
			String errorMessage = fieldError.getDefaultMessage();
			
			validationErrors.put(fieldName, errorMessage);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ProblemDetail> handleResouceNotFoundException(ResourceNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Resource Not Found");
		problemDetail.setDetail(e.getMessage());
		problemDetail.setProperty("DateTime", LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);

	}

}
