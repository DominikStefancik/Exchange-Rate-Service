package com.norton.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A class representing an error when data for the particular request is not found.
 * 
 * @author Dominik Stefancik
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8770203778283852244L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
