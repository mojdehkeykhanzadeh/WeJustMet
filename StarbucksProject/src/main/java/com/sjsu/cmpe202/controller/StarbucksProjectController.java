package com.sjsu.cmpe202.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> postPayment(@RequestParam int id, @RequestParam Integer cardID, @RequestParam double amt,@RequestParam Integer userId,@RequestParam int cardNumber) throws JsonProcessingException {
        
        Payment payment = paymentservice.makePayment(id,cardID, amt,userId,cardNumber);
        if(payment!=null) {
        return new ResponseEntity<>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payment),HttpStatus.OK);
        }else 
		return new ResponseEntity<>("Sorry amount can't be more than blance!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@RequestMapping(value = "/deductMoney", method = RequestMethod.POST)
    public String deductMoney(@RequestParam Integer userId ,@RequestParam double amt,@RequestParam int cardNumber) throws JsonProcessingException {
        
        double balance = paymentservice.deductMoney(userId, amt,cardNumber);
      
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(balance);
		
	}
        

        

}
