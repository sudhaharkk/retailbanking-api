package com.retail.api.model;

/*
* This is Account domain 
* @author  Sudhahar Vaithilingam
* @version 1.0
* @since   2022-07-01 
*/

public class Account {

	private String name;
	private double balance;
	private String oweTo;
	private double oweToAmount;
	private String oweFrom;
	private double oweFromAmount;

	public double getOweFromAmount() {
		return oweFromAmount;
	}

	public void setOweFromAmount(double oweFromAmount) {
		this.oweFromAmount = oweFromAmount;
	}

	public double getOweToAmount() {
		return oweToAmount;
	}

	public void setOweToAmount(double oweToAmount) {
		this.oweToAmount = oweToAmount;
	}

	public String getOweTo() {
		return oweTo;
	}

	public void setOweTo(String oweTo) {
		this.oweTo = oweTo;
	}

	public String getOweFrom() {
		return oweFrom;
	}

	public void setOweFrom(String oweFrom) {
		this.oweFrom = oweFrom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + ", oweTo=" + oweTo + ", oweToAmount=" + oweToAmount
				+ ", oweFrom=" + oweFrom + ", oweFromAmount=" + oweFromAmount + "]";
	}

}
