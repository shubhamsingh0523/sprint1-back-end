package com.capgemini.fms.exception;

public class ScheduledFlightException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ScheduledFlightException() {
		super();
	}
	
	public ScheduledFlightException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
		super(message , cause , enableSuppression , writableStackTrace);
	}
	
	public ScheduledFlightException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public ScheduledFlightException(String message) {
		super(message);
	}
	
	public ScheduledFlightException(Throwable cause) {
		super(cause);
	}
}