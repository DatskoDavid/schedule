package com.example.schedule.controller;

import com.example.schedule.DTO.group.req.GroupCreate;
import com.example.schedule.DTO.group.req.GroupUpdate;
import com.example.schedule.DTO.group.resp.GroupDTO;
import com.example.schedule.model.Group;
import com.example.schedule.repository.GroupRep;
import com.example.schedule.service.group.GroupServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    @Autowired
    GroupRep groupRep;

    private final GroupServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<GroupDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<GroupDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Group> deleteById(@PathVariable Long id) {

        groupRep.deleteById(id);

        return groupRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Group create(@RequestBody Group group) {

        return service.create(group);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Group update(@RequestBody Group group) {

        return service.update(group);
    }

    @Operation(summary = " DTO Group creation",
            description = " Adds new object to the Group list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroupDTO> createDTO(@RequestBody GroupCreate entity) {

        return ResponseEntity.ok(service.createDTO(entity));
    }

    @Operation(summary = " DTO Group updating",
            description = " Updates Group with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GroupDTO> updateDTO(@RequestBody GroupUpdate entity) {

        return ResponseEntity.ok(service.updateDTO(entity));

    }
}
