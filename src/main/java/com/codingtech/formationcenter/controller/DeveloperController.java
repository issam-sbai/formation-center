package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        List<Developer> developers = developerService.getAllDevelopers();
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Long id) {
        Developer developer = developerService.getDeveloperById(id);
        if (developer != null) {
            return new ResponseEntity<>(developer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        Developer createdDeveloper = developerService.createDeveloper(developer);
        return new ResponseEntity<>(createdDeveloper, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable Long id, @RequestBody Developer developer) {
        Developer updatedDeveloper = developerService.updateDeveloper(id, developer);
        if (updatedDeveloper != null) {
            return new ResponseEntity<>(updatedDeveloper, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
