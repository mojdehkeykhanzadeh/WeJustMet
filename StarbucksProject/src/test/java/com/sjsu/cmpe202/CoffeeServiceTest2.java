package com.sjsu.cmpe202;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sjsu.cmpe202.model.Coffee;
import com.sjsu.cmpe202.repository.CoffeeRepository;
import com.sjsu.cmpe202.service.CoffeeService;

class CoffeeServiceTest2 {

	@InjectMocks
	CoffeeService coffeeService;
	
	@Mock
	CoffeeRepository coffeeRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetByName() {
		
		Coffee coffee1 = new Coffee("coffee1", 2.00);
		Coffee coffee2 = new Coffee("coffee2", 2.50);
		Coffee coffee3 = new Coffee("coffee3", 3.00);

				
		when(coffeeRepository.findByName( "coffee1" ) ).thenReturn(coffee1);
		when(coffeeRepository.findByName( "coffee2" ) ).thenReturn(coffee2);
		
		when(coffeeRepository.save(anyObject())).thenReturn(coffee3);
		
		System.out.println(coffeeService.getCostByName("coffee1")+"\n");
		
		Coffee coffeeTest1 = coffeeService.getByName("coffee1");
		
		coffee3.setName("coffee4");
		coffee3.setPrice(4.00);
		
		assertNotNull(coffeeTest1);		
		assertEquals(coffee1, coffeeTest1);
		
		System.out.println(coffeeRepository.save(new Coffee("coffee3", 3.00)));
		System.out.println(coffeeService.create("coffee3", 3.00));	
		
		
	}

}
