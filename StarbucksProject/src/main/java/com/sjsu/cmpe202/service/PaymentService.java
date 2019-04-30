package com.sjsu.cmpe202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe202.repository.PaymentRepository;

@Service 
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	/**
	 * Todo : inject card repository dependency as well
	 */
	
	public Boolean makePayment(String cardID, String amount ){
		//Find card id
		//if balance is sufficient , accept payment 
		return true;
	}

}
