package com.example.schedule.DTO.schedule.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleDTO {

    private Long id;

    private Long numberOfWeek;
    private String dayOfWeek;
    private Long lessonNumber;

    private String groupsId;
    private String teachersId;
    private String subjectsId;
    private String audiencesId;

    private String startOfLesson;

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "id=" + id +
                ", numberOfWeek=" + numberOfWeek +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", lessonNumber=" + lessonNumber +
                ", groupsId='" + groupsId + '\'' +
                ", teachersId='" + teachersId + '\'' +
                ", subjectsId='" + subjectsId + '\'' +
                ", audiencesId='" + audiencesId + '\'' +
                ", startOfLesson='" + startOfLesson + '\'' +
                '}';
    }
}
