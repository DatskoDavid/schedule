package com.example.schedule.controller;

import com.example.schedule.DTO.schedule.req.ScheduleUpdate;
import com.example.schedule.DTO.schedule.req.ScheduleCreate;
import com.example.schedule.DTO.schedule.resp.ScheduleDTO;
import com.example.schedule.model.Schedule;
import com.example.schedule.repository.ScheduleRep;
import com.example.schedule.service.schedule.ScheduleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    @Autowired
    ScheduleRep scheduleRep;

    private final ScheduleServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<ScheduleDTO>>getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<ScheduleDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Schedule> deleteById(@PathVariable Long id) {

        scheduleRep.deleteById(id);

        return scheduleRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Schedule create(@RequestBody Schedule schedule) {

        return service.create(schedule);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Schedule update(@RequestBody Schedule schedule) {

        return service.update(schedule);
    }

    @Operation(summary = " DTO Schedule creation",
            description = " Adds new object to the Schedule list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ScheduleDTO> createDTO(@RequestBody ScheduleCreate entity) {

        return ResponseEntity.ok(service.createDTO(entity));
    }

    @Operation(summary = " DTO Schedule updating",
            description = " Updates Schedule with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ScheduleDTO> updateDTO(@RequestBody ScheduleUpdate entity) {

        return ResponseEntity.ok(service.updateDTO(entity));


    }
}
