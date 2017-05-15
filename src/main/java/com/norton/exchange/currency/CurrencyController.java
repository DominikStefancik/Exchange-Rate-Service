package com.norton.exchange.currency;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, List<Currency>> getCurrenciesForAllDays() {
		return CurrencyCache.getCache();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{date}")
	public List<Currency> getCurrenciesByDay(@PathVariable String date) {
		return CurrencyCache.getCache().get(date);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{date}/{currency}")
	public Currency getCurrency(@PathVariable String date, @PathVariable String currency) {
		List<Currency> currenciesForByDay = CurrencyCache.getCache().get(date);

		if (currenciesForByDay == null) {
			return null;
		}

		return currenciesForByDay	.stream()
															.filter(item -> item.getCurrency().equals(currency))
															.findFirst()
															.get();
	}
}
