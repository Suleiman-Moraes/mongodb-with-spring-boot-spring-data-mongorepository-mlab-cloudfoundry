package com.moraes.mongodbwithspring.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moraes.mongodbwithspring.api.model.Student;
import com.moraes.mongodbwithspring.api.model.dto.FilterStudentDTO;
import com.moraes.mongodbwithspring.api.service.IStudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/student")
public class StudentController {

    private IStudentService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student object) {
        object = service.create(object);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(object.getId()).toUri()).body(object.getId());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Student object) {
        service.update(id, object);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Student>> findAll(FilterStudentDTO filter) {
        return ResponseEntity.ok(service.findAll(filter));
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Student>> findByName(String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/name/email")
    public ResponseEntity<List<Student>> findByNameOrEmail(String name, String email) {
        return ResponseEntity.ok(service.findByNameOrEmail(name, email));
    }
}
