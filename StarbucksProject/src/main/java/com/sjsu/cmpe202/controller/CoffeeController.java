package com.sjsu.cmpe202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Coffee;
import com.example.demo.service.CoffeeService;

@RestController
public class CoffeeController {
	
	@Autowired
	private CoffeeService coffeeService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String name, @RequestParam double price)
	{
		Coffee p = coffeeService.create(name, price);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Coffee getCoffee(@RequestParam String name)
	{
		return coffeeService.getByName(name);
	}
	
	@RequestMapping("/getAll")
	public List<Coffee> getAll(){
		return coffeeService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String name, @RequestParam double price) {
		Coffee p = coffeeService.update(name, price);
		return p.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String name) {
		coffeeService.delete(name);
		return "Deleted " + name;
	}
	
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		coffeeService.deleteAll();
		return "Deleted all records";
	}
	
	@RequestMapping ("/getOrder")
	public double getOrder()
	{
		double orderCost = coffeeService.getOrderCost();
		return orderCost;
	}

}
