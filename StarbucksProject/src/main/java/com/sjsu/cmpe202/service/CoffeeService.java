package com.sjsu.cmpe202.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.model.Coffee;
import com.sjsu.cmpe202.repository.CoffeeRepository;

@Service
public class CoffeeService {
	
	public static double orderPrice;
	public static ArrayList<String> orderFinal = new ArrayList<String>();

	
	@Autowired
	private CoffeeRepository coffeeRepository;

	
	//Create operation
	public Coffee create(String name, double price)
	{
		orderPrice += price;		
		orderFinal.add(name);
		
		return coffeeRepository.save(new Coffee(name, price));
	}
	

	//Retrieve operation
	public List<Coffee> getAll()
	{
		return coffeeRepository.findAll();
	}
	
	public Coffee getByName(String name)
	{
		return coffeeRepository.findByName(name);
	}
	
	//update operation
	public Coffee update(String name, double price)
	{
		Coffee p = coffeeRepository.findByName(name);
		p.setName(name);
		p.setPrice(price);
		return coffeeRepository.save(p);
	}
	
	//Delete operation
	public void deleteAll()
	{
		orderPrice = 0;
		orderFinal.clear();
		coffeeRepository.deleteAll();
	}
	
	public void delete(String name)
	{
		Coffee p = coffeeRepository.findByName(name);
		coffeeRepository.delete(p);
		Coffee c = coffeeRepository.findByName(name);
		orderPrice -= c.getPrice();
	}
	
	public double getCostByName(String name)
	{
		Coffee p = coffeeRepository.findByName(name);
		double cost = p.getPrice();
		return cost;
	}

	
	public ArrayList<String> getOrderItems()
	{		
		return orderFinal;
	}
	
	public double getOrderPrice()
	{
		return orderPrice;
	}
	
	
}