package com.sjsu.cmpe202.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Document 
@JsonDeserialize(as = Payment.class)

public class Payment {
	@Id
	private String id;
	private String amount;
	private String cardID;
	
	@JsonCreator
	public Payment( @JsonProperty(value = "amount", required = true)String amount ,@JsonProperty(value = "cardID", required = true)String cardID) {
		this.cardID = cardID ;
	    this.amount = amount ;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardId(String cardID) {
		this.cardID = cardID;
	}


}
