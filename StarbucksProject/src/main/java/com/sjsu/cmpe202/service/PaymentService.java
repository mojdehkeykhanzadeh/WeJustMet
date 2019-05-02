package com.sjsu.cmpe202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sjsu.cmpe202.model.CardDetails;
import com.sjsu.cmpe202.model.Payment;
import com.sjsu.cmpe202.repository.CardDetailsRepository;
import com.sjsu.cmpe202.repository.PaymentRepository;

@Service 
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CardDetailsRepository carddetailsrepository;
	
	
	public Payment makePayment(Integer id,Integer cardID, double amount,int userId ){
		CardDetails result = carddetailsrepository.findByUserId(userId);
		 //if balance is sufficient , accept payment 
		if(result.getAmount()>= amount) {
			return paymentRepository.save(new Payment(id,amount, cardID , userId ));
		}
		else 
		return null;
	}
	public double deductMoney(Integer userId, double amount){

		CardDetails result = carddetailsrepository.findByUserId(userId);
        double newBal = result.getAmount() - amount;
        result.setAmount(newBal);
        carddetailsrepository.save(result);
        return newBal;
    }

}
