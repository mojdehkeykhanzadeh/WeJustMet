package com.example.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.api.model.User;
import com.example.mongo.api.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
		User u = userService.create(email, firstName, lastName);
		return u.toString();
	}
	
	@RequestMapping("/get")
	public User getUser(@RequestParam String email) {
		return userService.getByEmail(email);
	}
	@RequestMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
		User u = userService.update(firstName, firstName, lastName);
		return u.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String email) {
		userService.delete(email);
		return "Deleted "+email;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records";
	}

}
