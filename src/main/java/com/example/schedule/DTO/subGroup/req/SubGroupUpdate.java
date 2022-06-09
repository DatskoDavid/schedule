package com.example.schedule.DTO.subGroup.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubGroupUpdate {

    private Long id;
    private String name;
    private String faculty;
    private Long course;
    private Long numberOfStudents;

}
