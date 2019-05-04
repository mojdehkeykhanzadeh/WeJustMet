package com.example.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongo.api.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public User findByEmail(String email);
	public List<User> findByFirstName (String firstName);

}
