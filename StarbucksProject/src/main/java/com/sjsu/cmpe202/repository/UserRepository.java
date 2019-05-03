package com.sjsu.cmpe202.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sjsu.cmpe202.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
