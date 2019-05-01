package com.sjsu.cmpe202.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe202.model.CardDetails;


@Repository
public interface  CardDetailsRepository extends MongoRepository<CardDetails,Integer> {

	
	public CardDetails findByUserId(Integer userID);
//	public CardDetails findByUserId(Integer userID, Integer cardID);
 //   public List<CardDetails> findByLastName(String lastName);
//	public CardDetails findByUserId(CardDetails cardDetails);
	
}
