package com.norton.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A class representing an error when any of parameters have a wrong format.
 * 
 * @author Dominik Stefancik
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectParameterFormatException extends RuntimeException {

	private static final long serialVersionUID = -7884839345562284919L;

	public IncorrectParameterFormatException(String message) {
		super(message);
	}
}
