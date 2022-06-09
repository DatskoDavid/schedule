package com.example.schedule.DTO.teacher.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeacherUpdate {

    private Long id;

    private String name;
    private String address;
    private String position;

}
