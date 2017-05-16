package com.norton.exchange.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.norton.exchange.exception.IncorrectParameterFormatException;

public class RequestParameterValidator {

	private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
	private static final Pattern CURRENCY_PATTERN = Pattern.compile("[A-Z]{3}");

	public static void validateDateParameter(String date) {
		Matcher matcher = DATE_PATTERN.matcher(date);

		if (!matcher.matches()) {
			throw new IncorrectParameterFormatException("Incorrect format of the date parameter " + date);
		}
	}

	public static void validateCurrencyParameter(String currency) {
		Matcher matcher = CURRENCY_PATTERN.matcher(currency);

		if (!matcher.matches()) {
			throw new IncorrectParameterFormatException(
					"Incorrect format of the currency parameter " + currency);
		}

	}
}
