package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Education;

import java.util.List;

public interface EducationService {

    List<Education> getAllEducations();

    Education getEducationById(Long id);

    Education createEducation(Education education);

    Education updateEducation(Long id, Education education);

    void deleteEducation(Long id);
}
