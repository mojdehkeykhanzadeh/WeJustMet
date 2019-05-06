package com.sjsu.cmpe202.repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe202.model.CardDetails;


@Repository
public interface  CardDetailsRepository extends MongoRepository<CardDetails,Integer> {

	
	public CardDetails findByUserId(Integer userID, Integer cardNumber);

}
