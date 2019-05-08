package com.sjsu.cmpe202.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	String Id; 
	String email;
	String password;
	String firstName;
	String lastName;
	String userId;
	
	public User(String email, String password ,String firstName, String lastName, String userId) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		 
	}

	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String toString() {
		 return "User Email: " + email + " User Passwrod: " + password + " First Name: " + firstName + " Last Name: " +lastName +" User Id: "+ userId;
	}
	
}
