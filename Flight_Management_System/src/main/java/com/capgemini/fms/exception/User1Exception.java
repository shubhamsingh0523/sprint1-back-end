package com.capgemini.fms.exception;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.fms.entity.User1;

public class User1Exception extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User1Exception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User1Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public User1Exception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public User1Exception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public User1Exception(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public void deleteUser(@Valid Integer user_id) {
		// TODO Auto-generated method stub
		
	}

	public List<User1> show() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}