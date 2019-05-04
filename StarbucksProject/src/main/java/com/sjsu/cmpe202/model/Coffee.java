package com.sjsu.cmpe202.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Coffee {
	
	@Id
	String id;
	String name;
	double price;
	
	public Coffee( String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Coffee: "+name+" Price: " +price;
	}

	

}
