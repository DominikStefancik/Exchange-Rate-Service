package com.norton.exchange.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.norton.exchange.currency.CurrencyCache;

@Component
public class Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	@Scheduled(cron = "*/30 * * * * *")
	public void updateCurrencyCache() {
		logger.info("Updating currency cache");
		CurrencyCache.updateCache();
		logger.info("Currency cache updated on: {}", dateFormat.format(new Date()));
	}
}
