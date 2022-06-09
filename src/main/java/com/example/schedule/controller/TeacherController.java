package com.example.schedule.controller;

import com.example.schedule.DTO.teacher.req.TeacherCreate;
import com.example.schedule.DTO.teacher.req.TeacherUpdate;
import com.example.schedule.DTO.teacher.resp.TeacherDTO;
import com.example.schedule.model.Teacher;
import com.example.schedule.repository.TeacherRep;
import com.example.schedule.service.teacher.TeacherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    @Autowired
    TeacherRep teacherRep;

    private final TeacherServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<TeacherDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Teacher> deleteById(@PathVariable Long id){

        teacherRep.deleteById(id);

        return teacherRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Teacher create(@RequestBody Teacher teacher){

        return service.create(teacher);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Teacher update(@RequestBody Teacher teacher){

        return service.update(teacher);
    }

    @Operation(summary = " DTO Teacher creation",
            description = " Adds new object to the Teacher list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TeacherDTO> createDTO(@RequestBody TeacherCreate entity){

        return ResponseEntity.ok(service.createDTO(entity));
    }

    @Operation(summary = " DTO Teacher updating",
            description = " Updates Teacher with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TeacherDTO> updateDTO(@RequestBody TeacherUpdate entity){

        return ResponseEntity.ok(service.updateDTO(entity));
    }

}
