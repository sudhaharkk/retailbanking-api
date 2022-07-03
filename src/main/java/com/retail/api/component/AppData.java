package com.retail.api.component;

/**
 * This is component class to use in-memory object globally
 * @author Sudhahar
 * @version 1.0
 */

import java.util.Map;

/*
* @author  Sudhahar Vaithilingam
* @version 1.0
* * @since   2022-07-01 
*/

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.retail.api.model.Account;

@Component
public class AppData {

	private final Logger log = LoggerFactory.getLogger(AppData.class);
	private Map<String, Account> accountMap;

	public AppData() {
		super();
		accountMap = new ConcurrentHashMap<>();
	}

	public Map<String, Account> getAccountMap() {
		return accountMap;
	}

	public AppData setAccountMap(Map<String, Account> accountMap) {
		this.accountMap = accountMap;
		return this;
	}

}
