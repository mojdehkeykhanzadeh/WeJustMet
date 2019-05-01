package com.sjsu.cmpe202.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
 
@Document(collection = "CardDetails")

public class CardDetails {
    @Id
    int id;
    int cardNumber;
    int cardCode;
 	int userId;
    double amount;
 
    public CardDetails(int id, int cardNumber, int cardCode, int userId, double amount) {
    	this.id = id;
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
        this.userId = userId;
        this.amount = amount;
    }
    
  
  /*  public CardDetails() {
    }*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCardCode() {
		return cardCode;
	}

	public void setCardCode(int cardCode) {
		this.cardCode = cardCode;
	}
    
}
