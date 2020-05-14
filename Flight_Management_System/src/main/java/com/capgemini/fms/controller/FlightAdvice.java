package com.capgemini.fms.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.fms.exception.FlightException;
import com.capgemini.fms.exception.ErrorInfo;

@RestControllerAdvice
public class FlightAdvice {
	@ExceptionHandler(value = {FlightException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException1(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}

}
