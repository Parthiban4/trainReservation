package com.cts.project.trainReservation.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllEntity(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleEntity(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DetailsNotFoundException.class)
	public final ResponseEntity<Object> handleEntity1(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
}
