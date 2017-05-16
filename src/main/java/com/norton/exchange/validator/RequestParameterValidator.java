package com.norton.exchange.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.norton.exchange.exception.IncorrectParameterFormatException;

@Service
public class RequestParameterValidator {

	private final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	private final Pattern CURRENCY_PATTERN = Pattern.compile("[A-Z]{3}");

	public void validateDateParameter(String date) {
		Matcher matcher = DATE_PATTERN.matcher(date);

		if (!matcher.matches()) {
			throw new IncorrectParameterFormatException("Incorrect format of the date parameter " + date);
		}
	}

	public void validateCurrencyParameter(String currency) {
		Matcher matcher = CURRENCY_PATTERN.matcher(currency);

		if (!matcher.matches()) {
			throw new IncorrectParameterFormatException(
					"Incorrect format of the currency parameter " + currency);
		}

	}
}
