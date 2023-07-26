package com.moraes.mongodbwithspring.api.service.impl;

import org.springframework.stereotype.Service;

import com.moraes.mongodbwithspring.api.model.Department;
import com.moraes.mongodbwithspring.api.repository.IDepartmentRepository;
import com.moraes.mongodbwithspring.api.service.IDepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository repository;

    @Override
    public Department create(Department object) {
        return repository.save(object);
    }
}
