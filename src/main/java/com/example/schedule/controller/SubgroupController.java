package com.example.schedule.controller;

import com.example.schedule.DTO.subGroup.req.SubGroupCreate;
import com.example.schedule.DTO.subGroup.req.SubGroupUpdate;
import com.example.schedule.DTO.subGroup.resp.SubGroupDTO;
import com.example.schedule.model.Subgroup;
import com.example.schedule.repository.SubgroupRep;
import com.example.schedule.service.subgroup.SubgroupServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subgroups")
@RequiredArgsConstructor
public class SubgroupController {

    @Autowired
    SubgroupRep subgroupRep;

    private final SubgroupServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<SubGroupDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<SubGroupDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Subgroup> deleteById(@PathVariable Long id){

        subgroupRep.deleteById(id);

        return subgroupRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Subgroup create(@RequestBody Subgroup subgroup){

        return service.create(subgroup);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Subgroup update(@RequestBody Subgroup subgroup){

        return service.update(subgroup);
    }

    @Operation(summary = " DTO Subgroup creation",
            description = " Adds new object to the Subgroup list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SubGroupDTO> createDTO(@RequestBody SubGroupCreate entity){
        return ResponseEntity.ok(service.createDTO(entity));
    }
    @Operation(summary = " DTO Subgroup updating",
            description = " Updates Subgroup with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SubGroupDTO> updateDTO(@RequestBody SubGroupUpdate entity){
        return ResponseEntity.ok(service.updateDTO(entity));
    }

}
