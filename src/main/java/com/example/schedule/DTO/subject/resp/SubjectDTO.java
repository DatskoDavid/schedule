package com.example.schedule.DTO.subject.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubjectDTO {

    private Long id;

    private String name;
    private Long numberOfHours;
    private String finalControl;

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfHours=" + numberOfHours +
                ", finalControl='" + finalControl + '\'' +
                '}';
    }
}
