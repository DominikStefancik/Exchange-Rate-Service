package com.norton.exchange.currency;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.norton.exchange.exception.DataNotFoundException;
import com.norton.exchange.validator.RequestParameterValidator;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

	@Autowired
	RequestParameterValidator parameterValidator;

	@Autowired
	CurrencyCacheService cacheService;

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, List<Currency>> getCurrenciesForAllDays() {
		return cacheService.getCache();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{date}")
	public List<Currency> getCurrenciesByDay(@PathVariable String date) throws Exception {
		parameterValidator.validateDateParameter(date);

		List<Currency> currenciesByDay = cacheService.getCache().get(date);

		if (currenciesByDay == null) {
			throw new DataNotFoundException("No currency data for the date " + date);
		}

		return currenciesByDay;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{date}/{currency}")
	public Currency getCurrency(@PathVariable String date, @PathVariable String currency) {
		parameterValidator.validateDateParameter(date);
		parameterValidator.validateCurrencyParameter(currency);

		List<Currency> currenciesByDay = cacheService.getCache().get(date);

		if (currenciesByDay == null) {
			throw new DataNotFoundException("No currency data for the date " + date);
		}

		return currenciesByDay.stream()
													.filter(item -> item.getCurrency().equals(currency))
													.findFirst()
													.orElseThrow(() -> new DataNotFoundException(
															String.format("No data for the currency " + currency)));
	}
}
