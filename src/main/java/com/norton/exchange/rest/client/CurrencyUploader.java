package com.norton.exchange.rest.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.norton.exchange.config.ApplicationProperties;
import com.norton.exchange.currency.Currency;
import com.norton.exchange.util.CurrencyConverter;

@Service
public class CurrencyUploader {

	@Autowired
	private ApplicationProperties applicationProperties;

	@Autowired
	private CurrencyConverter converter;

	public Map<String, List<Currency>> uploadCurrencyDataFromECB() {

		Map<String, List<Currency>> currenciesList;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(applicationProperties.getEcbUrl(), String.class);
		currenciesList = converter.getCurrencyListFromECB(result);

		return currenciesList;
	}

}
