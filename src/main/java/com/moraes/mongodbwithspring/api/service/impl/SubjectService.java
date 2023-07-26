package com.moraes.mongodbwithspring.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.moraes.mongodbwithspring.api.model.Subject;
import com.moraes.mongodbwithspring.api.repository.ISubjectRepository;
import com.moraes.mongodbwithspring.api.service.ISubjectService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubjectService implements ISubjectService {

    private ISubjectRepository repository;

    @Override
    public Subject create(Subject object) {
        return repository.save(object);
    }

    @Override
    public List<Subject> saveAll(List<Subject> subjects) {
        if (!CollectionUtils.isEmpty(subjects)) {
            for (Subject subject : subjects) {
                if (StringUtils.hasText(subject.getId())) {
                    update(subject);
                } else {
                    create(subject);
                }
            }
        }
        return subjects;
    }

    private Subject update(Subject object) {
        return repository.save(object);
    }
}
