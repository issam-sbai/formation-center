package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Experience;

import java.util.List;

public interface ExperienceService {

    List<Experience> getAllExperiences();

    Experience getExperienceById(Long id);

    Experience createExperience(Experience experience);

    Experience updateExperience(Long id, Experience experience);

    void deleteExperience(Long id);
}
