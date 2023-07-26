package com.moraes.mongodbwithspring.api.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.moraes.mongodbwithspring.api.model.Student;
import com.moraes.mongodbwithspring.api.model.dto.FilterStudentDTO;
import com.moraes.mongodbwithspring.api.repository.IStudentRepository;
import com.moraes.mongodbwithspring.api.service.IDepartmentService;
import com.moraes.mongodbwithspring.api.service.IStudentService;
import com.moraes.mongodbwithspring.api.service.ISubjectService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    private IStudentRepository repository;

    private IDepartmentService departmentService;

    private ISubjectService subjectService;

    @Override
    public Student create(Student object) {
        object.setDepartment(departmentService.create(object.getDepartment()));
        object.setSubjects(subjectService.saveAll(object.getSubjects()));
        return repository.save(object);
    }

    @Override
    public Student findById(String id) {
        return repository.findById(id).orElse(new Student());
    }

    @Override
    public Page<Student> findAll(FilterStudentDTO filter) {
        final Sort sort = Sort.by(filter.getDirection(), filter.getProperty());
        if (filter.getSize() == null) {
            final List<Student> list = repository.findAll(sort);
            return new PageImpl<>(list, PageRequest.of(0, list.size(), sort), list.size());
        }
        return repository.findAll(PageRequest.of(filter.getPage(), filter.getSize(), sort));
    }

    @Override
    public Student update(String id, Student object) {
        object.setId(id);
        return repository.save(object);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Student> findByNameOrEmail(String name, String email) {
        return repository.findByNameOrEmail(name, email);
    }
}
