package com.sjsu.cmpe202.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.model.User;
import com.sjsu.cmpe202.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired  
	private UserRepository userRepository;
	
	
	//Create operation
	public User create (String email, String firstName, String lastName, String userNumber) {
		return userRepository.save(new User(email, firstName, lastName, userNumber));
	}
	//Retrieve operation
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//Update operation
	public User update(String email, String firstName, String lastName, String userNumber) {
		User u  = userRepository.findByEmail(email);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setUserNumber(userNumber);
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
