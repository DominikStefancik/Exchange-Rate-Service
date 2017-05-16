package com.norton.exchange.currency;

/**
 * A class representing a currency model.
 * 
 * @author Dominik Stefancik
 *
 */
public class Currency {

	private String currency;

	private double rate;

	public Currency() {

	}

	public Currency(String currency, double rate) {
		this.currency = currency;
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Currency: currency=");
		sb.append(this.getCurrency());
		sb.append(", rate: ");
		sb.append(this.getRate());

		return sb.toString();
	}

}
