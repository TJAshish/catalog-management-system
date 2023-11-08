package com.catalogmanagementsystem.exceptions;

	public class UserNotFoundException extends RuntimeException {
	    public UserNotFoundException(String message) {
	        super(message);
	    }
	}
