package com.norton.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectParameterFormatException extends RuntimeException {

	private static final long serialVersionUID = -7884839345562284919L;

	public IncorrectParameterFormatException(String message) {
		super(message);
	}
}
