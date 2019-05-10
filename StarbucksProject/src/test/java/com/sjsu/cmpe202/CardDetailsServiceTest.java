package com.sjsu.cmpe202;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sjsu.cmpe202.model.CardDetails;
import com.sjsu.cmpe202.repository.CardDetailsRepository;
import com.sjsu.cmpe202.service.CardDetailsService;

class CardDetailsServiceTest {

	@InjectMocks
	private CardDetailsService cardDetailsService;
	
	@Mock
	private CardDetailsRepository cardDetailsRepository;

	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void CardDetailsServiceTest1() {
		String actualString = new String("");
		actualString = "test1";
		int id = 1;
		int cardNumber = 123456789;
		int cardCode = 999;
		int userId = 123;
		double amount = 20.00;
		
		CardDetails expectedResults = new CardDetails(id, cardNumber, cardCode, userId, amount);
		
		when(cardDetailsRepository.save(anyObject())).thenReturn(expectedResults);
		
		//CardDetails expectedResults = new CardDetails(id, cardNumber, cardCode, userId, amount);
		CardDetails actualResults = new CardDetails(1, 123456789, 999, 123, 20.00);
		
		
		
		System.out.print(expectedResults);
		
		
		when(cardDetailsRepository.save(anyObject())).thenReturn(expectedResults);
		
		/*
		when(cardDetailsService.create(anyInt(), anyInt(), anyInt(), anyInt(), anyDouble())).thenReturn("Card is created successfully");
		
		//actualString = 
		System.out.println( cardDetailsService.create(id, cardNumber, cardCode, userId, amount));
		
		
		
		
		
		actualString = cardDetailsService.create(id, cardNumber, cardCode, userId, amount);	
		assertEquals("Card is created successfully", actualString);
		actualString = cardDetailsService.create(1, 123456789, 999, 123, 20.00);	
		assertEquals("40.0$ is added to your card: 123456789", actualString);
		
		CardDetails cardDetails = cardDetailsService.getBalance(userId, cardNumber);
		
		assertEquals(20.00, cardDetails);
		assertEquals(15.00, cardDetailsService.updateBalance(121, 123456789, 15.00));
		cardDetailsService.deleteCardDetails(121, 123456789);
		*/
	}


}
