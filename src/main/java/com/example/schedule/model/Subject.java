package com.example.schedule.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "subjects")
@Builder

public class Subject {

    @Id
    private Long id;

    private String name;
    private Long numberOfHours;
    private String finalControl;

    @JsonManagedReference
    @OneToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private Set<Schedule> schedules;

    public Subject() {
    }

    public Subject(Long id, String name, Long numberOfHours, String finalControl, Set<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.numberOfHours = numberOfHours;
        this.finalControl = finalControl;
        this.schedules = schedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(Long numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getFinalControl() {
        return finalControl;
    }

    public void setFinalControl(String finalControl) {
        this.finalControl = finalControl;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfHours=" + numberOfHours +
                ", finalControl='" + finalControl + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
