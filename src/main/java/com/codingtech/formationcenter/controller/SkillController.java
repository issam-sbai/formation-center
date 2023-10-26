package com.codingtech.formationcenter.controller;


import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Skill;
import com.codingtech.formationcenter.service.DeveloperService;
import com.codingtech.formationcenter.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = {"http://localhost:5174", "http://localhost:5173"})
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @Autowired
    private DeveloperService developerService;

    @PostMapping("/add")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill createdSkill = skillService.createSkill(skill);
        return new ResponseEntity<>(createdSkill, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill updatedSkill) {
        Skill updated = skillService.updateSkill(id, updatedSkill);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Skill skill = skillService.getSkillById(id);
        if (skill != null) {
            return new ResponseEntity<>(skill, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/{skillName}/developers")
    public ResponseEntity<List<Developer>> getDevelopersBySkill(@PathVariable String skillName)
    {
        System.out.println(skillName);
        List<Developer> developers = skillService.getDevelopersBySkill(skillName);
        return new ResponseEntity<>(developers, HttpStatus.OK);
    } */

    @GetMapping("/developers/{skillName}")
    public List<Developer> getDevelopersBySkill(@PathVariable String skillName) {
        return skillService.getDevelopersBySkill(skillName);
    }
}