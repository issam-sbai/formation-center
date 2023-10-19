package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Experience;
import com.codingtech.formationcenter.repo.DeveloperRepo;
import com.codingtech.formationcenter.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImp implements DeveloperService {

    private final DeveloperRepo developerRepository;
    private final ExperienceService experienceService;

    @Autowired
    public DeveloperServiceImp(DeveloperRepo developerRepository, ExperienceService experienceService) {
        this.developerRepository = developerRepository;
        this.experienceService = experienceService;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer getDeveloperById(int id) {
        Optional<Developer> developerOptional = developerRepository.findById(id);
        return developerOptional.orElse(null);
    }

    @Override
    public Developer createDeveloper(Developer developer) {
        // You may add additional validation or business logic before saving
        String hashedPassword = passwordEncoder.encode(developer.getPassword());
        //List<Role> roles=new ArrayList<>();
       // roles.add(new Role(4,"FORMATEUR"));
       // formateur.setPassword(hashedPassword);
       // formateur.setRoles(roles);
       // return formateurRepository.save(formateur);
        developer.setPassword(hashedPassword);
        return developerRepository.save(developer);
    }

    @Override
    public Developer updateDeveloper(int id, Developer developer) {
        Optional<Developer> existingDeveloperOptional = developerRepository.findById(id);

        if (existingDeveloperOptional.isPresent()) {
            Developer existingDeveloper = existingDeveloperOptional.get();
            // Update the existing developer with the new values
            existingDeveloper.setDescription(developer.getDescription());
            existingDeveloper.setUrlCv(developer.getUrlCv());
            // Update other properties as needed

            return developerRepository.save(existingDeveloper);
        }

        return null;
    }

    @Override
    public void deleteDeveloper(int id) {
        developerRepository.deleteById(id);
    }

    @Override
    public String addexpEriencesToDeveloper(int id, Experience experience) {

            Developer developer = null;
            Optional<Developer> optionaldeveloper = developerRepository.findById(id);
            System.out.println("ok2");
            System.out.println(optionaldeveloper.get());
            if (optionaldeveloper.isEmpty()) {
                Experience experience1 = experienceService.createExperience(experience);
                developer = optionaldeveloper.get();
                developer.getExperiences().add(experience1);
                System.out.println("ok3");
                developerRepository.save(developer);
                return "put is ok";
            }else {
                return "mut ex not ok";
            }

    }



}
