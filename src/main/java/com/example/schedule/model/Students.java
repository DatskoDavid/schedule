package com.example.schedule.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "students")
@Builder
public class Students {

    @Id
    private Long id;

    private String name;
    private String address;
    private String tel;
    private String specialization;
    @JsonBackReference
    @OneToMany(mappedBy = "studentsSubgroup", fetch = FetchType.EAGER)
    private List<Subgroup> subgroup;

    public Students() {
    }

    public Students(Long id, String name, String address, String tel, String specialization, List<Subgroup> subgroup) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.specialization = specialization;
        this.subgroup = subgroup;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Subgroup> getSubgroup() {
        return subgroup;
    }

    public void setSubgroups(List<Subgroup> subgroup) {
        this.subgroup = subgroup;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", specialization='" + specialization + '\'' +
                ", subgroup=" + subgroup +
                '}';
    }
}
