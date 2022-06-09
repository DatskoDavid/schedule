package com.example.schedule.DTO.subGroup.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubGroupDTO {

    private Long id;
    private String name;
    private String faculty;
    private Long course;
    private Long numberOfStudents;
    private String studentId;

    @Override
    public String toString() {
        return "SubGroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", numberOfStudents=" + numberOfStudents +
                ", studentId=" + studentId +
                '}';
    }
}
