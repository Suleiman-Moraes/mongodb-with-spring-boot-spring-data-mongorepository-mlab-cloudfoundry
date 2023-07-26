package com.moraes.mongodbwithspring.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moraes.mongodbwithspring.api.model.Subject;

public interface ISubjectRepository extends MongoRepository<Subject, String> {

}
