package com.retail.api.service;

import com.retail.api.model.Account;
import com.retail.api.model.PayAccount;
import com.retail.api.model.TopupAccount;

/*
* @author  Sudhahar Vaithilingam
* @version 1.0
* @since   2022-07-01 
*/

public interface IRetailService {

	public Account findbyName(String name);

	public Account topup(TopupAccount topupAccount);

	public Account pay(PayAccount payAccount);

	public void updateAccounts(Account account);

}
