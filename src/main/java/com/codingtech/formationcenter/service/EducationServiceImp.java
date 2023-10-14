package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Education;
import com.codingtech.formationcenter.repo.EducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImp implements EducationService {

    private final EducationRepo educationRepo;

    @Autowired
    public EducationServiceImp(EducationRepo educationRepo) {
        this.educationRepo = educationRepo;
    }

    @Override
    public List<Education> getAllEducations() {
        return educationRepo.findAll();
    }

    @Override
    public Education getEducationById(Long id) {
        Optional<Education> educationOptional = educationRepo.findById(id);
        return educationOptional.orElse(null);
    }

    @Override
    public Education createEducation(Education education) {
        return educationRepo.save(education);
    }

    @Override
    public Education updateEducation(Long id, Education education) {
        Optional<Education> existingEducationOptional = educationRepo.findById(id);

        if (existingEducationOptional.isPresent()) {
            Education existingEducation = existingEducationOptional.get();
            // Update the existing education with the new values
            existingEducation.setDegree(education.getDegree());
            existingEducation.setStartDate(education.getStartDate());
            existingEducation.setEndDate(education.getEndDate());
            // Update other properties as needed

            return educationRepo.save(existingEducation);
        }

        return null;
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepo.deleteById(id);
    }
}
