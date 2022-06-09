package com.example.schedule.DTO.schedule.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleCreate {

    private Long numberOfWeek;
    private String dayOfWeek;
    private Long lessonNumber;

    private Long groupsId;
    private Long teachersId;
    private Long subjectsId;
    private Long audiencesId;

    private String startOfLesson;

}
