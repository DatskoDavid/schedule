package com.example.schedule.DTO.student.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentsUpdateDTO {

    private Long id;
    private String name;
    private String address;
    private String tel;
    private String specialization;

}
