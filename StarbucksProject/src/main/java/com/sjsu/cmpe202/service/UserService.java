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
	public User create (int Id, String email, String password ,String firstName, String lastName, String userId) {
		return userRepository.save(new User(Id, email, password, firstName, lastName, userId));
	}
	//Retrieve operation
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//Update operation
	public User update(String email, String password, String firstName, String lastName, String userId) {
		User u  = userRepository.findByEmail(email);
		u.setPassword(password);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setUserId(userId);
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
