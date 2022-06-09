package com.example.schedule.controller;

import com.example.schedule.DTO.subject.req.SubjectCreate;
import com.example.schedule.DTO.subject.req.SubjectUpdate;
import com.example.schedule.DTO.subject.resp.SubjectDTO;
import com.example.schedule.model.Subject;
import com.example.schedule.repository.SubjectRep;
import com.example.schedule.service.subject.SubjectServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    @Autowired
    SubjectRep subjectRep;

    private final SubjectServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<SubjectDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<SubjectDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Subject> deleteById(@PathVariable Long id) {

        subjectRep.deleteById(id);

        return subjectRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Subject create(@RequestBody Subject subject) {

        return service.create(subject);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Subject update(@RequestBody Subject subject) {

        return service.update(subject);
    }


    @Operation(summary = " DTO Subject creation",
            description = " Adds new object to the Subject list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SubjectDTO> createDTO(@RequestBody SubjectCreate entity) {

        return ResponseEntity.ok(service.createDTO(entity));
    }

    @Operation(summary = " DTO Subject updating",
            description = " Updates Subject with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SubjectDTO> updateDTO(@RequestBody SubjectUpdate entity) {

        return ResponseEntity.ok(service.updateDTO(entity));

    }
}

