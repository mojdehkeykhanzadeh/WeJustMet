package com.sjsu.cmpe202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjsu.cmpe202.model.User;
import com.sjsu.cmpe202.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	//private ObjectMapper mapper = new ObjectMapper();
	
	@PostMapping("/createUser")
	public String create(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) throws JsonProcessingException {
		User user = userService.create(email, firstName, lastName);
		return user.toString();
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam String email) {
		return userService.getByEmail(email);
	}
	@GetMapping("/getAllUser")
	public List<User> getAll(){
		return userService.getAll();
	}
	@PostMapping("/updateUser")
	public String update(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
		User u = userService.update(email, firstName, lastName);
		return u.toString();
	}
	@RequestMapping("/deleteUser")
	public String delete(@RequestParam String email) {
		userService.delete(email);
		return "Deleted "+email;
	}
	@RequestMapping ("/deleteAllUser")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records";
	}
}
