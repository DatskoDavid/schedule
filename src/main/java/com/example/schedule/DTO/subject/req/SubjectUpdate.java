package com.example.schedule.DTO.subject.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubjectUpdate {

    private Long id;

    private String name;
    private Long numberOfHours;
    private String finalControl;

}
