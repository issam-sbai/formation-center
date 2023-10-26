package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Recruiter;
import com.codingtech.formationcenter.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiters")
@CrossOrigin(origins = {"http://localhost:5174", "http://localhost:5173"})
public class RecruiterController {

    private final RecruiterService recruiterService;

    @Autowired
    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @GetMapping
    public List<Recruiter> getAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @GetMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable Long id) {
        return recruiterService.getRecruiterById(id);
    }

    @PostMapping
    public Recruiter saveRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterService.saveRecruiter(recruiter);
    }

    @DeleteMapping("/{id}")
    public void deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteRecruiter(id);
    }
}

