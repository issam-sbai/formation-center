package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Experience;
import com.codingtech.formationcenter.entity.Promotion;
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
    public ResponseEntity<Developer> getDeveloperById(@PathVariable int id) {
        Developer developer = developerService.getDeveloperById(id);
        if (developer != null) {
            return new ResponseEntity<>(developer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public Developer saveParticipant(@RequestBody Developer developer) {
        return developerService.createDeveloper(developer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable int id, @RequestBody Developer developer) {
        Developer updatedDeveloper = developerService.updateDeveloper(id, developer);
        if (updatedDeveloper != null) {
            return new ResponseEntity<>(updatedDeveloper, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable int id) {
        developerService.deleteDeveloper(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/experiences")
    public ResponseEntity<String> addexperiencesTodev(
            @PathVariable int id,
            @RequestBody Experience experience) {
        System.out.println("ok"+ id);
        String updatedFormation = developerService.addexpEriencesToDeveloper(id, experience);

        if (updatedFormation != null) {

            return ResponseEntity.ok(updatedFormation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
