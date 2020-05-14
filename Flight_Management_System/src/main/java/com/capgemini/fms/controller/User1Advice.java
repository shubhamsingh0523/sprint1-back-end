package com.capgemini.fms.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.fms.exception.User1Exception;
import com.capgemini.fms.exception.ErrorInfo;

@RestControllerAdvice
public class User1Advice {
	@ExceptionHandler(value = {User1Exception.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public Error handleException1(Exception ex) {
		return new Error(ex.getMessage());
	}

}