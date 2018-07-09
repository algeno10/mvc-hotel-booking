package com.george.booking.exception;

import java.io.Serializable;

public class PropertyNotFoundException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public PropertyNotFoundException() {
		this("Property is not available!");
	}
	
	public PropertyNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}

}
