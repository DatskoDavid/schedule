package com.example.schedule.controller;

import com.example.schedule.DTO.audience.req.AudienceCreate;
import com.example.schedule.DTO.audience.req.AudienceUpdate;
import com.example.schedule.DTO.audience.resp.AudienceDTO;
import com.example.schedule.model.Audience;
import com.example.schedule.repository.AudienceRep;
import com.example.schedule.service.audience.AudienceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/audiences")
@RequiredArgsConstructor
public class AudienceController {

    @Autowired
    AudienceRep audienceRep;


    private final AudienceServiceImpl service;


    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<AudienceDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(service.getAll(page, size).getContent());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<AudienceDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Audience> deleteById(@PathVariable Long id){

        audienceRep.deleteById(id);

        return audienceRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Audience create(@RequestBody Audience audience){

        return service.create(audience);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Audience update(@RequestBody Audience audience){

        return service.update(audience);
    }

    @Operation(summary = " DTO Audience creation",
            description = " Adds new object to the Audience list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AudienceDTO> createDTO(@RequestBody AudienceCreate entity){

        return ResponseEntity.ok(service.createDTO(entity));
    }

    @Operation(summary = " DTO Audience updating",
            description = " Updates Audience with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AudienceDTO> updateDTO(@RequestBody AudienceUpdate entity){

        return ResponseEntity.ok(service.updateDTO(entity));
    }

}
