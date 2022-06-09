package com.example.schedule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity(name = "subgroup")
@Builder

public class Subgroup {

    @Id
    private Long id;

    private String name;
    private String faculty;
    private Long course;
    private Long numberOfStudents;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "studentsSubgroup_id")
    private Students studentsSubgroup;

    @JsonBackReference
    @OneToMany(mappedBy = "subgroups", fetch = FetchType.EAGER)
    private Set<Group> groups;

    public Subgroup() {
    }

    public Subgroup(Long id, String name, String faculty, Long course, Long numberOfStudents, Students studentsSubgroup, Set<Group> groups) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.course = course;
        this.numberOfStudents = numberOfStudents;
        this.studentsSubgroup = studentsSubgroup;
        this.groups = groups;
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Long getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Students getStudents() {
        return studentsSubgroup;
    }

    public void setStudents(Students studentsSubgroup) {
        this.studentsSubgroup = studentsSubgroup;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Students getStudentsSubgroup() {
        return studentsSubgroup;
    }

    public void setStudentsSubgroup(Students studentsSubgroup) {
        this.studentsSubgroup = studentsSubgroup;
    }


    @Override
    public String toString() {
        return "Subgroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", numberOfStudents=" + numberOfStudents +
                ", studentsSubgroup=" + studentsSubgroup +
                ", groups=" + groups +
                '}';
    }
}
