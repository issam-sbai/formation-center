package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Experience;
import com.codingtech.formationcenter.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
@CrossOrigin(origins = {"http://localhost:5174", "http://localhost:5173"})
public class ExperienceController {
    private final ExperienceService experienceService;
    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = experienceService.getAllExperiences();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {
        Experience experience = experienceService.getExperienceById(id);
        if (experience != null) {
            return new ResponseEntity<>(experience, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        Experience createdExperience = experienceService.createExperience(experience);
        return new ResponseEntity<>(createdExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        Experience updatedExperience = experienceService.updateExperience(id, experience);
        if (updatedExperience != null) {
            return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
