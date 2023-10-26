package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Education;
import com.codingtech.formationcenter.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educations")
@CrossOrigin(origins = {"http://localhost:5174", "http://localhost:5173"})
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> educations = educationService.getAllEducations();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        Education education = educationService.getEducationById(id);
        if (education != null) {
            return new ResponseEntity<>(education, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education createdEducation = educationService.createEducation(education);
        return new ResponseEntity<>(createdEducation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education education) {
        Education updatedEducation = educationService.updateEducation(id, education);
        if (updatedEducation != null) {
            return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
