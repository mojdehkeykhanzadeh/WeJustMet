package com.sjsu.cmpe202.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjsu.cmpe202.model.Payment;
import com.sjsu.cmpe202.service.PaymentService;
@RestController
public class StarbucksProjectController {
	@Autowired
	private PaymentService paymentservice;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
    public String postPayment(@RequestParam int id, @RequestParam Integer cardID, @RequestParam double amt,@RequestParam Integer userId) throws JsonProcessingException {
        
        Payment payment = paymentservice.makePayment(id,cardID, amt,userId);
      
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payment);
		
	}
	@RequestMapping(value = "/deductMoney", method = RequestMethod.POST)
    public String deductMoney(@RequestParam Integer userId , double amt) throws JsonProcessingException {
        
        double balance = paymentservice.deductMoney(userId, amt);
      
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(balance);
		
	}
        

        

}
