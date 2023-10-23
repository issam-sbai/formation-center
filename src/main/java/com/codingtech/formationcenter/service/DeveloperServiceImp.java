package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.dto.DevSocialnetworkDto;
import com.codingtech.formationcenter.dto.NiveauOfSkillRequest;
import com.codingtech.formationcenter.entity.*;
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
    private final SocialNetworkService socialNetworkService;
    private final DevSocialNetworkService devSocialNetwork;
    private final SkillService skillService;
    private final NiveauOfSkillDeveloperService niveauOfSkillDeveloperService;

    @Autowired
    public DeveloperServiceImp(DeveloperRepo developerRepository, ExperienceService experienceService, SocialNetworkService socialNetworkService, DevSocialNetworkService devSocialNetwork, SkillService skillService, NiveauOfSkillDeveloperService niveauOfSkillDeveloperService) {
        this.developerRepository = developerRepository;
        this.experienceService = experienceService;
        this.socialNetworkService = socialNetworkService;
        this.devSocialNetwork = devSocialNetwork;
        this.skillService = skillService;
        this.niveauOfSkillDeveloperService = niveauOfSkillDeveloperService;
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
        List<Role> roles=new ArrayList<>();
        roles.add(new Role(2,"DEVELOPER"));
        developer.setRoles(roles);
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
            if(developer.getNiveauOfSkillDevelopers().size() >0){

                existingDeveloper.getNiveauOfSkillDevelopers().addAll(developer.getNiveauOfSkillDevelopers());
            }


            // Update other properties as needed

            return developerRepository.save(existingDeveloper);
        }

        return null;
    }
    @Override
    public List<Developer> getDevelopersBySkill(String skillName) {
        return developerRepository.findByNiveauOfSkillDevelopersSkillSkillName(skillName);
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

    @Override
    public void updateDeveloper(Developer developer) {

        developerRepository.save(developer);
    }


    @Override
    public void updateDeveloperNetwork( DevSocialnetworkDto devSocialnetworkDto,int developerId) {

        SocialNetwork socialNetwork = socialNetworkService.getOrCreatesocialNetwork(devSocialnetworkDto.getSosailnetworkName());
        Developer developer = getDeveloperById(developerId);
        List<DevSocialNetwork> niveauOfSkillDevelopers = developer.getDevsocialNetworks();
        DevSocialNetwork existingNiveauOfSkill = null;
        for (DevSocialNetwork nsd : niveauOfSkillDevelopers) {
            if (nsd.getSocialNetwork().equals(socialNetwork)) {
                existingNiveauOfSkill = nsd;
                break;
            }
        }
        if (existingNiveauOfSkill != null) {
            existingNiveauOfSkill.setUrlSocialNetwork(devSocialnetworkDto.getUrlSOcialNetwork());
        } else {
            DevSocialNetwork newNiveauOfSkill = new DevSocialNetwork();
            newNiveauOfSkill.setSocialNetwork(socialNetwork);
            newNiveauOfSkill.setUrlSocialNetwork(devSocialnetworkDto.getUrlSOcialNetwork());
            newNiveauOfSkill.setDeveloper(developer);

            niveauOfSkillDevelopers.add(newNiveauOfSkill);
            devSocialNetwork.saveNiveauOfSkillDeveloper(newNiveauOfSkill);
        }
        developerRepository.save(developer);
    }
    @Override
    public void updateDeveloperSkill(NiveauOfSkillRequest niveauOfSkillRequest, int developerId) {

        // Step 2: Receive data for the NiveauOfSkillDeveloper update
        // (Assuming NiveauOfSkillRequest has skill information and niveauOfSkillDeveloper)

        // Step 3: Create a new Skill if necessary (check if it already exists)
        Skill skill = skillService.getOrCreateSkill(niveauOfSkillRequest.getSkillName());

        // Step 4: Get the Developer
        Developer developer = getDeveloperById(developerId);

        // Step 5: Check if the NiveauOfSkillDeveloper already exists for the developer
        List<NiveauOfSkillDeveloper> niveauOfSkillDevelopers = developer.getNiveauOfSkillDevelopers();

        NiveauOfSkillDeveloper existingNiveauOfSkill = null;

        for (NiveauOfSkillDeveloper nsd : niveauOfSkillDevelopers) {
            if (nsd.getSkill().equals(skill)) {
                existingNiveauOfSkill = nsd;
                break;
            }
        }

        if (existingNiveauOfSkill != null) {
            // NiveauOfSkillDeveloper already exists, update its properties
            existingNiveauOfSkill.setNiveauOfSkillDeveloper(niveauOfSkillRequest.getNiveauOfSkillDeveloper());
        } else {
            // NiveauOfSkillDeveloper doesn't exist, create a new one
            NiveauOfSkillDeveloper newNiveauOfSkill = new NiveauOfSkillDeveloper();
            newNiveauOfSkill.setSkill(skill);
            newNiveauOfSkill.setNiveauOfSkillDeveloper(niveauOfSkillRequest.getNiveauOfSkillDeveloper());

            // Associate the NiveauOfSkillDeveloper with the Developer
            newNiveauOfSkill.setDeveloper(developer);

            // Add the new NiveauOfSkillDeveloper to the list
            niveauOfSkillDevelopers.add(newNiveauOfSkill);
            niveauOfSkillDeveloperService.saveNiveauOfSkillDeveloper(newNiveauOfSkill);
        }
        developerRepository.save(developer);
    }



}
