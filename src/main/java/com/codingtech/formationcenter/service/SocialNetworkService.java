package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Skill;
import com.codingtech.formationcenter.entity.SocialNetwork;

import java.util.List;

public interface SocialNetworkService {

    SocialNetwork createSkill(SocialNetwork skill);

    SocialNetwork updateSkill(Long id, SocialNetwork updatedSkill);

    List<SocialNetwork> getAllSkills();

    SocialNetwork getSkillById(Long id);

    void deleteSkill(Long id);

    List<Developer> getDevelopersBySocialNetwork(String skillName);

    SocialNetwork getOrCreatesocialNetwork(String skillName);
}
