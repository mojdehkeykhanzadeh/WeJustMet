package com.sjsu.cmpe202.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	String Id; 
	String email;
	String firstName;
	String lastName;
	String userNumber;
	
	public User(String email, String firstName, String lastName, String userNumber) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userNumber = userNumber;
		 
	}

	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserNumber() {
		return userNumber;
	}
	
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	

	public String toString() {
		 return "User Email: " + email + " First Name: " + firstName + " Last Name: " +lastName +" User Number: "+ userNumber;
	}
	
}
