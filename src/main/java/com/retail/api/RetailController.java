package com.retail.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.api.model.Account;
import com.retail.api.model.PayAccount;
import com.retail.api.model.TopupAccount;
import com.retail.api.service.IRetailService;

/**
 * This is controller class
 * 
 * @author Sudhahar
 * @version 1.0
 */

@RestController
@RequestMapping("/retail")
public class RetailController {

	private final Logger log = LoggerFactory.getLogger(RetailController.class);

	@Autowired
	IRetailService service;

	/**
	 * creates the customer if not exist, if case of exist return customer
	 * information
	 *
	 * @param customer name
	 * @return Customer Object
	 */
	@PostMapping("/api/login")
	@ResponseBody
	public Object login(@RequestParam("name") String name) throws Exception {
		log.info("Login Service!!!!!!!!!!!!!!!!!");
		return service.findbyName(name.trim());

	}

	/**
	 * topup the amount to respective customer
	 *
	 * @param TopupAccount Object
	 * @return Account Object
	 */
	@RequestMapping(value = "/api/topup", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public Object topup(@RequestBody TopupAccount pay) throws Exception {
		log.info("Topup Service!!!!!!!!!!!!!!!!!");
		return service.topup(pay);

	}

	/**
	 * One customer pay amount to another customer
	 *
	 * @param PayAccount Object
	 * @return Account Object
	 */

	@PostMapping(value = "/api/pay", consumes = "application/json", produces = "application/json")
	public Account pay(@RequestBody PayAccount pay) {
		return service.pay(pay);
	}

}
