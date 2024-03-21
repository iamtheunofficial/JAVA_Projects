package com.health.globalexceptionhandler;

import java.nio.file.AccessDeniedException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.health.error.ErrorPage;
import com.health.exception.PatientNotFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorPage> constraintViolation(ConstraintViolationException e){
	ErrorPage error=	new ErrorPage(e.getMessage(), HttpStatus.FORBIDDEN);
	return new ResponseEntity<ErrorPage>(error,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorPage> dataIntegerity(DataIntegrityViolationException e){
	
		ErrorPage error=	new ErrorPage(e.getMessage(), HttpStatus.FORBIDDEN);
	return new ResponseEntity<ErrorPage>(error,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorPage> patientNotFound(PatientNotFoundException e){
	System.out.println("eeeee");
		ErrorPage error=	new ErrorPage(e.getMessage(), HttpStatus.UNAUTHORIZED);
	return new ResponseEntity<ErrorPage>(error,HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorPage> patientNotFound(AccessDeniedException e){
		ErrorPage error=	new ErrorPage(e.getMessage(), HttpStatus.UNAUTHORIZED);
	return new ResponseEntity<ErrorPage>(error,HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorPage> commonException(Exception e){
	System.out.println("eeeee");
		ErrorPage error=	new ErrorPage(e.getMessage(), HttpStatus.UNAUTHORIZED);
	return new ResponseEntity<ErrorPage>(error,HttpStatus.UNAUTHORIZED);
	}
}
