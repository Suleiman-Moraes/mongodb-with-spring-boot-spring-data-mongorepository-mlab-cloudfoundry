package com.moraes.mongodbwithspring.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moraes.mongodbwithspring.api.model.Student;
import java.util.List;


public interface IStudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByNameOrEmail(String name, String email);
}
