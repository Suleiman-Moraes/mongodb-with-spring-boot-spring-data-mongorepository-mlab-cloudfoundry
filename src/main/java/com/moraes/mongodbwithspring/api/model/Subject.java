package com.moraes.mongodbwithspring.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "subject")
public class Subject {

    @Id
    private String id;

    @Field(name = "subject_name")
    private String name;

    @Field(name = "marks_obtained")
    private String marksObtained;
}
