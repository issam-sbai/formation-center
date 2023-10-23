package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Skill;

import java.util.List;

public interface SkillService {
    Skill createSkill(Skill skill);

    Skill updateSkill(Long id, Skill updatedSkill);

    List<Skill> getAllSkills();

    Skill getSkillById(Long id);

    void deleteSkill(Long id);

    List<Developer> getDevelopersBySkill(String skillName);

    Skill getOrCreateSkill(String skillName);
}
