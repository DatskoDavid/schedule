package com.example.schedule.controller;

import com.example.schedule.DTO.student.req.StudentsCreateDTO;
import com.example.schedule.DTO.student.req.StudentsUpdateDTO;
import com.example.schedule.DTO.student.resp.StudentDTO;
import com.example.schedule.model.Students;
import com.example.schedule.repository.StudentRep;
import com.example.schedule.service.student.StudentsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {


    @Autowired
    StudentRep studentRep;

    private final StudentsServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<StudentDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Students> deleteById(@PathVariable Long id){

        studentRep.deleteById(id);

        return studentRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Students create(@RequestBody Students student){

        return service.create(student);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Students update(@RequestBody Students student){

        return service.update(student);
    }

    @Operation(summary = " DTO Student creation",
            description = " Adds new object to the Student list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDTO> createDTO(@RequestBody StudentsCreateDTO entity){
        return ResponseEntity.ok(service.createDTO(entity));
    }

    @Operation(summary = " DTO Student updating",
            description = " Updates Student with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDTO> updateDTO(@RequestBody StudentsUpdateDTO entity){
        return ResponseEntity.ok(service.updateDTO(entity));
    }

}
