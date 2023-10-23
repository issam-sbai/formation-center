package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.*;
import com.codingtech.formationcenter.repo.SocialNetworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocialNetworkServiceImp implements SocialNetworkService {

    private final SocialNetworkRepo socialNetworkRepo;


    @Autowired
    public SocialNetworkServiceImp(SocialNetworkRepo socialNetworkRepo) {
        this.socialNetworkRepo = socialNetworkRepo;
    }

    @Override
    public SocialNetwork createSkill(SocialNetwork skill) {
        return socialNetworkRepo.save(skill);
    }


    @Override
    public SocialNetwork updateSkill(Long id, SocialNetwork updatedSkill) {
        Optional<SocialNetwork> existingSkill = socialNetworkRepo.findById(id);

        if (existingSkill.isPresent()) {
            SocialNetwork skill = existingSkill.get();
            skill.setNetworkName(updatedSkill.getNetworkName());
            return socialNetworkRepo.save(skill);
        }

        return null; // Skill not found
    }
    @Override
    public List<SocialNetwork> getAllSkills() {
        return socialNetworkRepo.findAll();
    }

    @Override
    public SocialNetwork getSkillById(Long id) {
        return socialNetworkRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSkill(Long id) {
        socialNetworkRepo.deleteById(id);
    }
    @Override
    public List<Developer> getDevelopersBySocialNetwork(String skillName) {
        List<SocialNetwork> skills = socialNetworkRepo.findSocialNetworkByNetworkName(skillName);

        List<Developer> developers = new ArrayList<>();

        for (SocialNetwork skill : skills) {
            developers.addAll(skill.getDevSocialNetworks()
                    .stream()
                    .map(DevSocialNetwork::getDeveloper)
                    .collect(Collectors.toList()));
        }

        return developers;
    }

    @Override
    public SocialNetwork getOrCreatesocialNetwork(String skillName) {
        // Check if the skill with the given name already exists
        SocialNetwork existingSkill = socialNetworkRepo.findByNetworkName(skillName);

        if (existingSkill != null) {
            // Skill with the given name already exists, return it
            return existingSkill;
        } else {
            // Skill doesn't exist, create a new one
            SocialNetwork newSkill = new SocialNetwork();
            newSkill.setNetworkName(skillName);

            // Save the new skill to the database
            return socialNetworkRepo.save(newSkill);
        }
    }
}
