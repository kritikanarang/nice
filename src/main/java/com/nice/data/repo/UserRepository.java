package com.nice.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nice.entities.User;

public interface UserRepository extends MongoRepository<User,Long> {
	 User findByUsername(String username);
}
