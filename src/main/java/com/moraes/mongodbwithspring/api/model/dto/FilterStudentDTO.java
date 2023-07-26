package com.moraes.mongodbwithspring.api.model.dto;

import org.springframework.data.domain.Sort.Direction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterStudentDTO {

    @Builder.Default
    private Integer page = 0;

    private Integer size;

    @Builder.Default
    private Direction direction = Direction.DESC;

    @Builder.Default
    private String property = "id";
}
