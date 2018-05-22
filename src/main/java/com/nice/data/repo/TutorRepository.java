package com.nice.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nice.entities.TutorTo;

public interface TutorRepository extends MongoRepository<TutorTo, String> {


}
