package com.sjsu.cmpe202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	private ObjectMapper mapper = new ObjectMapper();
	
	@PostMapping("/createUser")
	public String create(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String userNumber) throws JsonProcessingException {
		User user = userService.create(email, firstName, lastName, userNumber);
		//return user.toString();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
	}
	
	@GetMapping("/getUser")
	public String getUser(@RequestParam String email) throws JsonProcessingException {
		User user = userService.getByEmail(email);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
	}
	@GetMapping("/getAllUser")
	public List<User> getAll(){
		return userService.getAll();
	}
	@PostMapping("/updateUser")
	public String update(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String userNumber) throws JsonProcessingException {
		User u = userService.update(email, firstName, lastName, userNumber);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);
	}
	@DeleteMapping("/deleteUser")
	public String delete(@RequestParam String email) {
		userService.delete(email);
		return "Deleted "+email;
	}
	@DeleteMapping ("/deleteAllUser")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records";
	}
}
