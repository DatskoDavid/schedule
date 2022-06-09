package com.example.schedule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "audiences")
@Builder

public class Audience {

    @Id
    private Long id;

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "audiences", fetch = FetchType.EAGER)
    private Set<Schedule> schedules;

    public Audience() {
    }

    public Audience(Long id, String name, Set<Schedule> schedules) {
        this.id = id;
        this.name = name;
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

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Audience{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
