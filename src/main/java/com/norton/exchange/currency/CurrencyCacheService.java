package com.norton.exchange.currency;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.norton.exchange.rest.client.CurrencyUploader;

@Component
public class CurrencyCacheService {

	private Map<String, List<Currency>> cache;

	@Autowired
	private CurrencyUploader uploader;

	public Map<String, List<Currency>> getCache() {
		if (cache == null) {
			updateCache();
		}

		return cache;
	}

	public void updateCache() {
		cache = uploader.uploadCurrencyDataFromECB();
	}

}
