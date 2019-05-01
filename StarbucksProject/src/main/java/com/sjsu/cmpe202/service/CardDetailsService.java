package com.sjsu.cmpe202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.model.CardDetails;
import com.sjsu.cmpe202.repository.CardDetailsRepository;

@Service
public class CardDetailsService {
	
	@Autowired
	private CardDetailsRepository cardDetailsRepository;

	public CardDetails create(int id, int cardNumber, int cardCode, int userId, double amount) {
		return cardDetailsRepository.save(new CardDetails(id, cardNumber, cardCode, userId, amount));
	}
	
	public CardDetails getBalance(int userID) {
		
		System.out.println("222222222222222");
		return cardDetailsRepository.findByUserId(userID);
		//return cardDetailsRepository.findByUserId(new CardDetails(id, cardNumber));
	}
}
