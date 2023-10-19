package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Skill;
import com.codingtech.formationcenter.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
}
