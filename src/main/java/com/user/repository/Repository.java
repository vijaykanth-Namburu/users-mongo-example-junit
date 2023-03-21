package com.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.model.User;

public interface Repository extends MongoRepository<User, Integer>{

}
