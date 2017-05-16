package com.norton.exchange.currency;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norton.exchange.rest.client.CurrencyUploader;

/**
 * A class for accessing a cache of currency lists from various days.
 * 
 * @author Dominik Stefancik
 *
 */
@Service
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
