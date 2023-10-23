package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepo  extends JpaRepository<Skill,Long> {

    List<Skill> findSkillBySkillName(String skillName);
    Skill findBySkillName(String skillName);
}
