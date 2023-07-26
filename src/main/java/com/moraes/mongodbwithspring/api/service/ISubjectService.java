package com.moraes.mongodbwithspring.api.service;

import java.util.List;

import com.moraes.mongodbwithspring.api.model.Subject;

public interface ISubjectService {

    Subject create(Subject object);

    List<Subject> saveAll(List<Subject> subjects);
}
