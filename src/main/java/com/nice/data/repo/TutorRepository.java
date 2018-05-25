package com.nice.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nice.entities.TutorTo;

public interface TutorRepository extends MongoRepository<TutorTo, String> {

	@Query("{'tutorId': ?0}")
	public TutorTo findUnique(String tutorId);

}
