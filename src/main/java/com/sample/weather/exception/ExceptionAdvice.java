package com.sample.weather.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sample.weather.holder.Errors;


@ControllerAdvice
@Component
public class ExceptionAdvice {
	
	@ExceptionHandler(WeatherServiceException.class)
	public ResponseEntity<Errors> handleApplicationException (WeatherServiceException ex){
		return new ResponseEntity<>(new Errors(ex.getErrorCode(),ex.getErrorMessage()),HttpStatus.valueOf(ex.getStatusCode()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Errors> handleException (Exception ex){
		return new ResponseEntity<>(new Errors("TECHNICAL_ERR","Technical error"),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}