package com.norton.exchange.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * A class for accessing the settings from the config file application.properties.
 * 
 * @author Dominik Stefancik
 *
 */
@Component
@ConfigurationProperties
public class ApplicationProperties {

	@Value("${ecb.url}")
	private String ecbUrl;

	public String getEcbUrl() {
		return ecbUrl;
	}
}
