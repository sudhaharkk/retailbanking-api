package com.retail.api.model;

/*
* This is PayAccount domain class 
* @author  Sudhahar Vaithilingam
* @version 1.0
* @since   2022-07-01 
*/

public class PayAccount {

	private String name;
	private double amount;
	private String payTo;
	
	public String getPayTo() {
		return payTo;
	}

	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

}
