package com.sjsu.cmpe202.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Coffee;
import com.example.demo.repository.CoffeeRepository;

@Service
public class CoffeeService {
	
	@Autowired
	private CoffeeRepository coffeeRepository;
	
	//Create operation
	public Coffee create(String name, double price)
	{
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
		coffeeRepository.deleteAll();
	}
	
	public void delete(String name)
	{
		Coffee p = coffeeRepository.findByName(name);
		coffeeRepository.delete(p);
	}
	
	public double getCostByName(String name)
	{
		Coffee p = coffeeRepository.findByName(name);
		double cost = p.getPrice();
		return cost;
	}
	

	
	
	
	
	public double getOrderCost() 
	{
		
		ArrayList<String> order = new ArrayList<String>();
		order.add("Coffee1");
		order.add("Coffee3");
		order.add("Coffee9");
		
		double orderCost = 0.00;
		
		for(int i = 0; i < order.size(); i++)
		{
			Coffee p = coffeeRepository.findByName(order.get(i));
			orderCost += p.getPrice();
		}
		
		return orderCost;
	}

}
