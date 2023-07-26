package com.moraes.mongodbwithspring.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    private String email;

    @DBRef
    private Department department;

    @DBRef
    private List<Subject> subjects;
}
