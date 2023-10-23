package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.DevSocialNetwork;
import com.codingtech.formationcenter.entity.Developer;

import java.util.Optional;

public interface DevSocialNetworkService {
    DevSocialNetwork saveNiveauOfSkillDeveloper(DevSocialNetwork devSocialNetwork);

    Optional<DevSocialNetwork> getNiveauOfSkillDeveloperById(Long id);

    void deleteNiveauOfSkillDeveloper(Long id);
}
