package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.NiveauOfSkillDeveloper;

import java.util.Optional;

public interface NiveauOfSkillDeveloperService {
    NiveauOfSkillDeveloper saveNiveauOfSkillDeveloper(NiveauOfSkillDeveloper niveauOfSkillDeveloper);

    Optional<NiveauOfSkillDeveloper> getNiveauOfSkillDeveloperById(Long id);

    void deleteNiveauOfSkillDeveloper(Long id);
}
