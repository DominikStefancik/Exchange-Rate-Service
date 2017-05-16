package com.norton.exchange.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.norton.exchange.currency.CurrencyCacheService;

/**
 * A class which periodically calls scheduled tasks operating on currency data.
 * 
 * @author Dominik Stefancik
 *
 */
@Component
public class CurrencyScheduler {

	private final Logger logger = LoggerFactory.getLogger(CurrencyScheduler.class);

	private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	@Autowired
	private CurrencyCacheService cacheService;

	/**
	 * Periodically runs a task which updates the currency cache. The task is run every 3 hours.
	 * 
	 */
	@Scheduled(cron = "* * */3 * * *")
	public void updateCurrencyCache() {
		logger.info("Updating currency cache");
		cacheService.updateCache();
		logger.info("Currency cache updated on: {}", dateFormat.format(new Date()));
	}
}
