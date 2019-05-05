package com.sjsu.cmpe202.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe202.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public User findByEmail(String email);
	public List<User> findByFirstName (String firstName);

}
