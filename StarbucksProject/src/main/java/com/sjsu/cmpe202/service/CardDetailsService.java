package com.sjsu.cmpe202.service;

import java.util.List;
import java.util.function.Predicate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.model.CardDetails;
import com.sjsu.cmpe202.repository.CardDetailsRepository;

@Service
public class CardDetailsService {
	
	@Autowired
	private CardDetailsRepository cardDetailsRepository;

	
	 @Autowired
	    MongoTemplate mongoTemplate;

	public String create(int id, int cardNumber, int cardCode, int userId, double amount) {
	//	cardDetailsRepository.findByUserId(userID);
		
		String message = "";
		
		if(String.valueOf(cardNumber).length() != 9) {
			message = "Entered card number is not valid";
			
		}else if(String.valueOf(cardCode).length() != 3) {
			message = "Entered card code is not valid";
		}else {
		
			CardDetails cardDetails = getCardDetailsByUserId(userId);
			if(cardDetails != null && cardDetails.getCardNumber() == cardNumber){
				amount = cardDetails.getAmount() + amount;
				cardDetails = cardDetailsRepository.save(new CardDetails(id, cardNumber, cardCode, userId, amount));
				message = amount + "$ is added to your card: " + cardNumber;
			}else if (cardDetails == null){
				cardDetails = cardDetailsRepository.save(new CardDetails(id, cardNumber, cardCode, userId, amount));
				message = "Card is created successfully";
			}
			else{
				cardDetails = null;
				message = "You already have a card. Please recharge in the same";
			}
		}
		return message;
	}
	
	public CardDetails getBalance(int userID, int cardNumber) {
		
			Query query = new Query();
			query.addCriteria(Criteria.where("userId").is(userID));
			query.addCriteria(Criteria.where("cardNumber").is(cardNumber));
			CardDetails cardDetails = null;
			
		List<CardDetails> cardDetailsList = mongoTemplate.find(query,CardDetails.class);
		if(!cardDetailsList.isEmpty()) {
			cardDetails = cardDetailsList.get(0);
		}
		 return cardDetails;
	
	}
	
	public CardDetails getCardDetailsByUserId(int userID) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userID));
		CardDetails cardDetails = null;
		
		List<CardDetails> cardDetailsList = mongoTemplate.find(query,CardDetails.class);
		if(!cardDetailsList.isEmpty()) {
			cardDetails = cardDetailsList.get(0);
		}
	 return cardDetails;

	}
	
	public String deleteCardDetails(int userID, int cardNumber) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userID));
		query.addCriteria(Criteria.where("cardNumber").is(cardNumber));
		CardDetails cardDetails = mongoTemplate.findAndRemove(query, CardDetails.class);
		System.out.println("Deleted document : " + cardDetails);
		System.out.println("Deleted document : " + cardDetails.getUserId());
		System.out.println("Deleted document : " + cardDetails.getCardNumber());


		
		if(cardDetails != null) {
			return "Your card is deleted";
		}
	 return "You dont have any such card";

	}
	
	public String updateBalance(int userID, int cardNumber, double amount) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userID));
		query.addCriteria(Criteria.where("cardNumber").is(cardNumber));
		
		CardDetails cardDetails = mongoTemplate.findOne(query, CardDetails.class);
		cardDetails.setAmount(amount);
		
		
		System.out.println("Updated document : " + cardDetails);
		System.out.println("Updated document : " + cardDetails.getUserId());
		System.out.println("Updated document : " + cardDetails.getCardNumber());

		cardDetails = cardDetailsRepository.save(cardDetails);
		
		System.out.println("Updated document : " + cardDetails);
		System.out.println("Updated document : " + cardDetails.getUserId());
		System.out.println("Updated document : " + cardDetails.getCardNumber());
		System.out.println("Updated document : " + cardDetails.getAmount());
		
		if(cardDetails != null) {
			return "The amount is updated";
		}
		
	 return "You dont have any such card";

	}
	
	
}
