package com.moraes.mongodbwithspring.api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.moraes.mongodbwithspring.api.model.Student;
import com.moraes.mongodbwithspring.api.model.dto.FilterStudentDTO;

public interface IStudentService {
    
    Student create(Student object);

    Student update(String id, Student object);

    boolean delete(String id);

    Student findById(String id);

    Page<Student> findAll(FilterStudentDTO filter);

    List<Student> findByName(String name);

    List<Student> findByNameOrEmail(String name, String email);
}
