package com.sjsu.cmpe202.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Document 

public class Payment {
	@Id
	private Integer id;
	private double amount;
	private Integer cardID;
	private Integer userId;
	
	public Payment( int id ,double amount ,Integer cardID,Integer userId) {
		this.id = id;
		this.cardID = cardID ;
	    this.amount = amount ;
	    this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Integer getCardID() {
		return cardID;
	}
	public void setCardId(Integer cardID) {
		this.cardID = cardID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


}
