package com.sjsu.cmpe202.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sjsu.cmpe202.model.Coffee;
import com.sjsu.cmpe202.service.CoffeeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CoffeeController {
	
	@Autowired
	private CoffeeService coffeeService;
	private ObjectMapper mapper = new ObjectMapper();

	
	@PostMapping("/createOrder")
	public String create(@RequestParam String name, @RequestParam double price) throws JsonProcessingException
	{
		Coffee c = coffeeService.create(name, price);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
	}
	
	@GetMapping("/getOrderByName")
	public String getCoffee(@RequestParam String name) throws JsonProcessingException
	{
		Coffee c = coffeeService.getByName(name);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
	}
	
	@GetMapping("/getAllOrder")
	public List<Coffee> getAll(){
		return coffeeService.getAll();
	}
	
	@PostMapping("/updateOrder")
	public String update(@RequestParam String name, @RequestParam double price) throws JsonProcessingException {
		Coffee p = coffeeService.update(name, price);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
	}
	
	@DeleteMapping("/deleteOrderByName")
	public String delete(@RequestParam String name) {
		coffeeService.delete(name);
		return "Deleted " + name;
	}
	
	@DeleteMapping ("/deleteAllOrder")
	public String deleteAll() {
		coffeeService.deleteAll();
		return "Deleted all records";
	}
	
	
	@GetMapping ("/getTotalOrderItems")
	public ArrayList<String> getItems()
	{
		return coffeeService.getOrderItems();
	}
	
	@GetMapping ("/getTotalOrderPrice")
	public double getPrice()
	{
		return coffeeService.getOrderPrice();
	}
	
	
}