package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo  extends JpaRepository<Skill,Long> {
}
