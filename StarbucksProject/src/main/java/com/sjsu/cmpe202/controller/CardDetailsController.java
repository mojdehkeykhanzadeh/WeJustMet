package com.sjsu.cmpe202.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjsu.cmpe202.model.CardDetails;
import com.sjsu.cmpe202.service.CardDetailsService;

@RestController
public class CardDetailsController {
	
	@Autowired
	public CardDetailsService cardDetailsService;
	
	
	//private ObjectMapper mapper = new ObjectMapper();
	
	
	@PostMapping("/createCard")
	public String create(@RequestParam int id, @RequestParam int cardNumber, @RequestParam int cardCode, @RequestParam int userId, @RequestParam double amount) throws JsonProcessingException {
		return cardDetailsService.create(userId, cardNumber, cardCode, userId, amount);
		
		
		
		//return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cardDetails);
	}
	
	@GetMapping("/getBalance")
	public String getBalance(@RequestParam int userId, @RequestParam int cardNumber) throws JsonProcessingException {
		CardDetails cardDetails = cardDetailsService.getBalance(userId, cardNumber);
	
		return Double.toString(cardDetails.getAmount());
		
	}
	
	@DeleteMapping("/deleteCard")
	public String delete(@RequestParam int userId, @RequestParam int cardNumber) throws JsonProcessingException {
		return  cardDetailsService.deleteCardDetails(userId, cardNumber);
	
	}
	
	@PutMapping("/updateBalance")
	public String updateBalance(@RequestParam int userId, @RequestParam int cardNumber, @RequestParam double amount) throws JsonProcessingException {
		return  cardDetailsService.updateBalance(userId, cardNumber, amount);
	}
	
	@RequestMapping("/hello")
	public String Hello()
	{ 
		return "Greetings";
	}
	

}
