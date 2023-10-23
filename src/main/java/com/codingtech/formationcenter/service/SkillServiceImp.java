package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Skill;
import com.codingtech.formationcenter.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingtech.formationcenter.entity.NiveauOfSkillDeveloper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SkillServiceImp implements SkillService {


    private final SkillRepo skillRepository;

    @Autowired
    public SkillServiceImp(SkillRepo skillRepository) {
        this.skillRepository = skillRepository;

    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }


    @Override
    public Skill updateSkill(Long id, Skill updatedSkill) {
        Optional<Skill> existingSkill = skillRepository.findById(id);

        if (existingSkill.isPresent()) {
            Skill skill = existingSkill.get();
            skill.setSkillName(updatedSkill.getSkillName());
            // Update other skill properties as needed
            return skillRepository.save(skill);
        }

        return null; // Skill not found
    }
    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
    @Override
    public List<Developer> getDevelopersBySkill(String skillName) {
        List<Skill> skills = skillRepository.findSkillBySkillName(skillName);

        List<Developer> developers = new ArrayList<>();

        for (Skill skill : skills) {
            developers.addAll(skill.getNiveauOfSkillDevelopers()
                    .stream()
                    .map(NiveauOfSkillDeveloper::getDeveloper)
                    .collect(Collectors.toList()));
        }

        return developers;
    }

    @Override
    public Skill getOrCreateSkill(String skillName) {
        // Check if the skill with the given name already exists
        Skill existingSkill = skillRepository.findBySkillName(skillName);

        if (existingSkill != null) {
            // Skill with the given name already exists, return it
            return existingSkill;
        } else {
            // Skill doesn't exist, create a new one
            Skill newSkill = new Skill();
            newSkill.setSkillName(skillName);

            // Save the new skill to the database
            return skillRepository.save(newSkill);
        }
    }
}