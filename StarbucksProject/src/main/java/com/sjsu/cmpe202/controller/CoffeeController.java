package com.sjsu.cmpe202.controller;

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

@RestController
public class CoffeeController {
	
	@Autowired
	private CoffeeService coffeeService;

	
	@PostMapping("/create")
	public String create(@RequestParam String name, @RequestParam double price)
	{
		Coffee p = coffeeService.create(name, price);
		return p.toString();
	}
	
	@GetMapping("/get")
	public Coffee getCoffee(@RequestParam String name)
	{
		return coffeeService.getByName(name);
	}
	
	@GetMapping("/getAll")
	public List<Coffee> getAll(){
		return coffeeService.getAll();
	}
	
	@PostMapping("/update")
	public String update(@RequestParam String name, @RequestParam double price) {
		Coffee p = coffeeService.update(name, price);
		return p.toString();
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam String name) {
		coffeeService.delete(name);
		return "Deleted " + name;
	}
	
	@DeleteMapping ("/deleteAll")
	public String deleteAll() {
		coffeeService.deleteAll();
		return "Deleted all records";
	}
	
	
	@GetMapping ("/getOrder")
	public double getOrder()
	{
		double orderCost = coffeeService.orderTotal();
		return orderCost;
	}
	
	
}