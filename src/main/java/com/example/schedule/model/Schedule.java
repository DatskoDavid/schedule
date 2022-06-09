package com.example.schedule.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;


@Entity(name = "schedules")
@Builder

public class Schedule {

    @Id
    private Long id;

    private Long numberOfWeek;
    private String dayOfWeek;
    private Long lessonNumber;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groups_id")
    private Group groups;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teachers_id")
    private Teacher teachers;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subjects_id")
    private Subject subjects;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "audiences_id")
    private Audience audiences;


    private String startOfLesson;

    public Schedule() {
    }

    public Schedule(Long id, Long numberOfWeek, String dayOfWeek, Long lessonNumber, Group groups, Teacher teachers, Subject subjects, Audience audiences, String startOfLesson) {
        this.id = id;
        this.numberOfWeek = numberOfWeek;
        this.dayOfWeek = dayOfWeek;
        this.lessonNumber = lessonNumber;
        this.groups = groups;
        this.teachers = teachers;
        this.subjects = subjects;
        this.audiences = audiences;
        this.startOfLesson = startOfLesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(Long numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Long getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Long lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Group getGroups() {
        return groups;
    }

    public void setGroups(Group groups) {
        this.groups = groups;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }

    public Subject getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject subjects) {
        this.subjects = subjects;
    }

    public Audience getAudiences() {
        return audiences;
    }

    public void setAudiences(Audience audiences) {
        this.audiences = audiences;
    }

    public String getStartOfLesson() {
        return startOfLesson;
    }

    public void setStartOfLesson(String startOfLesson) {
        this.startOfLesson = startOfLesson;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return getId().equals(schedule.getId()) && Objects.equals(getNumberOfWeek(), schedule.getNumberOfWeek()) && Objects.equals(getDayOfWeek(), schedule.getDayOfWeek()) && Objects.equals(getLessonNumber(), schedule.getLessonNumber()) && Objects.equals(getGroups(), schedule.getGroups()) && Objects.equals(getTeachers(), schedule.getTeachers()) && Objects.equals(getSubjects(), schedule.getSubjects()) && Objects.equals(getAudiences(), schedule.getAudiences()) && Objects.equals(getStartOfLesson(), schedule.getStartOfLesson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumberOfWeek(), getDayOfWeek(), getLessonNumber(), getGroups(), getTeachers(), getSubjects(), getAudiences(), getStartOfLesson());
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", numberOfWeek=" + numberOfWeek +
                ", dayOfWeek=" + dayOfWeek +
                ", lessonNumber=" + lessonNumber +
                ", groups=" + groups +
                ", teachers=" + teachers +
                ", subjects=" + subjects +
                ", audiences=" + audiences +
                ", startOfLesson=" + startOfLesson +
                '}';
    }
}
