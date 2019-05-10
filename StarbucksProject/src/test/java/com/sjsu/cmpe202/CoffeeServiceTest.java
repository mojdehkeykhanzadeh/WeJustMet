package com.sjsu.cmpe202;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sjsu.cmpe202.repository.*;
import com.sjsu.cmpe202.service.CoffeeService;

class CoffeeServiceTest {

	@InjectMocks
	private CoffeeService coffeeService;

	@Mock
	private CoffeeRepository coffeeRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void orderTest1() {
		ArrayList<String> orderItems = new ArrayList<String>();
		ArrayList<String> testItems = new ArrayList<String>();
		
		testItems.add("coffee1");
		testItems.add("coffee2");
		testItems.add("coffee3");
		
		coffeeService.create("coffee1", 1.50);
		coffeeService.create("coffee2", 2.50);
		coffeeService.create("coffee3", 1.75);
		
		orderItems = coffeeService.getOrderItems();
		
		assertEquals(testItems, orderItems);
		
		double testPrice = coffeeService.getOrderPrice();
		
		assertEquals(5.75, testPrice);
		
		coffeeService.deleteAll();
								
	}
	
	@Test
	void orderTest2() {
		ArrayList<String> orderItems = new ArrayList<String>();
		ArrayList<String> testItems = new ArrayList<String>();
		
		testItems.add("Americano");
		testItems.add("Iced Green Tea");
		//testItems.add("Java Latte");
		
		coffeeService.create("Americano", 3.50);
		coffeeService.create("Iced Green Tea", 2.50);
		coffeeService.create("Java Latte", 2.75);
		coffeeService.delete("Java Latte", 2.75);
		
		orderItems = coffeeService.getOrderItems();
		
		assertEquals(testItems, orderItems);
		
		double testPrice = coffeeService.getOrderPrice();
		
		assertEquals(6.00, testPrice);
		
		coffeeService.deleteAll();
								
	}
}
