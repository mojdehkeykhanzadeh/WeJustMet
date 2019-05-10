package com.sjsu.cmpe202;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sjsu.cmpe202.model.User;
import com.sjsu.cmpe202.repository.UserRepository;
import com.sjsu.cmpe202.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private User actualResults;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void userServiceTest1() {
		
		int    id = 121;
		String email = "test123@test.com";
		String password = "pass123";
		String firstName = "Tommy";
		String lastName = "Yao";
		String userNumber = "123";
		
		
		
		
		User expectedResults = new User(id, email, password, firstName, lastName, userNumber);
		
		
		when(userRepository.save(anyObject())).thenReturn(expectedResults);
		
		User actualResults   = userService.create(id, email, password, firstName, lastName, userNumber);
		
		System.out.println(actualResults);
		
		assertEquals(expectedResults, actualResults);

		
		
	}


}
