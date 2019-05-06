package com.sjsu.cmpe202.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.sjsu.cmpe202.model.Payment;

public interface PaymentRepository extends MongoRepository <Payment , Integer> {
	List<Payment> findPaymentByCardNumber(@Param("CardNumber") Integer cardNumber);

}
