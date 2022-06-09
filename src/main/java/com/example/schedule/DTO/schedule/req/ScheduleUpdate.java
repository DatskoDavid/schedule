package com.example.schedule.DTO.schedule.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleUpdate {

    private Long id;

    private Long numberOfWeek;
    private String dayOfWeek;
    private Long lessonNumber;
    private String startOfLesson;

}
