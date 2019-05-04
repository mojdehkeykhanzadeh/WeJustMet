package com.example.mongo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.api.model.User;
import com.example.mongo.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired  
	private UserRepository userRepository;
	
	
	//Create operation
	public User create (String email, String firstName, String lastName) {
		return userRepository.save(new User(email, firstName, lastName));
	}
	//Retrieve operation
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//Update operation
	public User update(String email, String firstName, String lastName) {
		User u  = userRepository.findByEmail(email);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		return userRepository.save(u);
	}
	
	//Delete operation
	public void deleteAll() {
		userRepository.deleteAll();
	}
	public void delete(String email) {
		User u = userRepository.findByEmail(email);
		userRepository.delete(u);
	}
		
		

}
