package com.norton.exchange.rest.client;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.norton.exchange.currency.Currency;
import com.norton.exchange.util.CurrencyConverter;

public class CurrencyUploader {

	private static final String ECB_URL = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml";

	public static Map<String, List<Currency>> uploadCurrencyData() {

		Map<String, List<Currency>> currenciesList;

		try {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(ECB_URL, String.class);
			currenciesList = CurrencyConverter.getCurrencyList(result);
		} catch (RestClientException rcex) {
			rcex.printStackTrace();
			currenciesList = new TreeMap<>();
		}

		return currenciesList;
	}

}
