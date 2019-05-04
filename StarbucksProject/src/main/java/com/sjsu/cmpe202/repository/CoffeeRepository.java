package com.sjsu.cmpe202.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe202.model.Coffee;

@Repository
public interface CoffeeRepository extends MongoRepository<Coffee, String>{
	
	public Coffee findByName(String name);

}
