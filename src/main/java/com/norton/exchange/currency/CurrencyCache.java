package com.norton.exchange.currency;

import java.util.List;
import java.util.Map;

import com.norton.exchange.rest.client.CurrencyUploader;

public class CurrencyCache {

	private static Map<String, List<Currency>> cache;

	public static Map<String, List<Currency>> getCache() {
		if (cache == null) {
			updateCache();
		}

		return cache;
	}

	public static void updateCache() {
		cache = CurrencyUploader.uploadCurrencyData();
	}

}
