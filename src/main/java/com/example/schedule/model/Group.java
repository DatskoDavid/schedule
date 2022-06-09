package com.example.schedule.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity(name = "groups")
@Builder
public class Group {

    @Id
    private Long id;

    private Long numberOfGroup;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subgroups_id")
    private Subgroup subgroups;

    @JsonBackReference
    @OneToMany(mappedBy = "groups", fetch = FetchType.EAGER)
    private Set<Schedule> schedules;

    public Group() {
    }

    public Group(Long id, Long numberOfGroup, Subgroup subgroups, Set<Schedule> schedules) {
        this.id = id;
        this.numberOfGroup = numberOfGroup;
        this.subgroups = subgroups;
        this.schedules = schedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(Long numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public Subgroup getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(Subgroup subgroups) {
        this.subgroups = subgroups;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", numberOfGroup=" + numberOfGroup +
                ", subgroups=" + subgroups +
                ", schedules=" + schedules +
                '}';
    }
}
