package com.system.evoucher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidAssignmentException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidAssignmentException(String message) {
		super(message);
	}
	
	public InvalidAssignmentException(String message, Throwable t) {
		super(message, t);
	}
}
