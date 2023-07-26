package com.moraes.mongodbwithspring.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moraes.mongodbwithspring.api.model.Department;

public interface IDepartmentRepository extends MongoRepository<Department, String> {

}
