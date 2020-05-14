package com.capgemini.fms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.fms.exception.ScheduledFlightException;
import com.capgemini.fms.exception.ErrorInfo;

@RestControllerAdvice
public class ScheduledFlightAdvice {
	
	@ExceptionHandler(value= {ScheduledFlightException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}

}