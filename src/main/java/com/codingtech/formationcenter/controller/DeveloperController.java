package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.dto.DevSocialnetworkDto;
import com.codingtech.formationcenter.dto.NiveauOfSkillRequest;
import com.codingtech.formationcenter.entity.*;
import com.codingtech.formationcenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/developers")
@CrossOrigin(origins = {"http://localhost:5174", "http://localhost:5173"})
public class DeveloperController {

    private final DeveloperService developerService;
    private final SkillService skillService;
    private final SocialNetworkService socialNetworkService;
    private final DevSocialNetworkService devSocialNetwork;
    private final NiveauOfSkillDeveloperService niveauOfSkillDeveloperService;
    @Autowired
    public DeveloperController(DeveloperService developerService, SkillService skillService, SocialNetworkService socialNetworkService, DevSocialNetworkService devSocialNetwork, NiveauOfSkillDeveloperService niveauOfSkillDeveloperService) {
        this.developerService = developerService;
        this.skillService = skillService;
        this.socialNetworkService = socialNetworkService;
        this.devSocialNetwork = devSocialNetwork;
        this.niveauOfSkillDeveloperService = niveauOfSkillDeveloperService;
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
    public ResponseEntity<String> createDeveloper(@RequestBody Developer developer) {
        try {
            Developer createdDeveloper = developerService.createDeveloper(developer);
            return ResponseEntity.ok("Developer created successfully");
        } catch (RuntimeException e) {
            // Handle the case where a runtime exception occurs, including the case where the username already exists
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
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

    @PutMapping("/{developerId}/updateNiveauOfSkill")
    public ResponseEntity<String> updateNiveauOfSkill(
            @PathVariable int developerId,
            @RequestBody NiveauOfSkillRequest niveauOfSkillRequest) {

        // Save the changes to the database
        developerService.updateDeveloperSkill(niveauOfSkillRequest,developerId);

        return ResponseEntity.ok("NiveauOfSkillDeveloper updated successfully");
    }

    @GetMapping("skill/{skillName}")
    public List<Developer> getDevelopersBySkill(@PathVariable String skillName) {
        return skillService.getDevelopersBySkill(skillName);
    }

    @PutMapping("/{developerId}/updatenetwork")
    public ResponseEntity<String> updatesocialnetwork(
            @PathVariable int developerId,
            @RequestBody DevSocialnetworkDto devSocialnetworkDto) {
            developerService.updateDeveloperNetwork(devSocialnetworkDto,developerId);
        return ResponseEntity.ok("social network updated successfully");
    }


    @PostMapping("/{developerId}/update")
    public ResponseEntity<Developer> updateDeveloperWithImage(
            @PathVariable int developerId,
            @RequestParam("imageFile") MultipartFile imageFile

    ) {
        Developer developer = developerService.getDeveloperById(developerId);

        if (developer == null) {
            System.out.println("1");
            return ResponseEntity.notFound().build();
        }
        System.out.println("3");
        Developer updatedDeveloper = developerService.updateDeveloperWithImage(developer, imageFile);

        if (updatedDeveloper != null) {
            return ResponseEntity.ok(updatedDeveloper);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }







}
