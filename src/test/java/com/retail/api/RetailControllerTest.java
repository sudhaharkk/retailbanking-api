package com.retail.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.api.model.Account;
import com.retail.api.model.PayAccount;
import com.retail.api.model.TopupAccount;
import com.retail.api.service.IRetailService;

@WebMvcTest
public class RetailControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IRetailService service;

	private static ObjectMapper mapper = new ObjectMapper();

	private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@SuppressWarnings("unchecked")
	@Test
	void testLogin() throws Exception {

		Account account = new Account();
		account.setName("Kavin");
		account.setBalance(100L);

		Mockito.when(service.findbyName(ArgumentMatchers.any())).thenReturn(account);
		String json = mapper.writeValueAsString("");
		try {
			mockMvc.perform(post("/retail/api/login?name=Kavin").contentType(MediaType.APPLICATION_JSON)
					.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testTopup() throws JsonProcessingException {
		TopupAccount topaccount = new TopupAccount();
		topaccount.setName("Kavin");
		topaccount.setAmount(100L);

		Account account = new Account();
		account.setName("Kavin");
		account.setBalance(100L);

		Mockito.when(service.topup(ArgumentMatchers.any())).thenReturn(account);
		String json = mapper.writeValueAsString(topaccount);
		try {
			mockMvc.perform(post("/retail/api/topup").contentType(MediaType.APPLICATION_JSON)
					.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testPay() throws JsonProcessingException {
		PayAccount payccount = new PayAccount();
		payccount.setName("Kavin");
		payccount.setAmount(100L);
		payccount.setPayTo("Kayal");

		Account account = new Account();
		account.setName("Kavin");
		account.setBalance(100L);

		Mockito.when(service.topup(ArgumentMatchers.any())).thenReturn(account);
		String json = mapper.writeValueAsString(payccount);
		try {
			mockMvc.perform(post("/retail/api/pay").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
					.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
