package com.example.schedule.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "teachers")
@Builder

public class Teacher {

    @Id
    private Long id;

    private String name;
    private String address;
    private String position;

    @JsonManagedReference
    @OneToMany(mappedBy = "teachers", fetch = FetchType.EAGER)
    private Set<Schedule> schedules;

    public Teacher() {
    }

    public Teacher(Long id, String name, String address, String position, Set<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
