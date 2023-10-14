package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Experience;
import com.codingtech.formationcenter.repo.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceIml implements ExperienceService {

    private final ExperienceRepo experienceRepo;

    @Autowired
    public ExperienceServiceIml(ExperienceRepo experienceRepo) {
        this.experienceRepo = experienceRepo;
    }

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepo.findAll();
    }

    @Override
    public Experience getExperienceById(Long id) {
        Optional<Experience> experienceOptional = experienceRepo.findById(id);
        return experienceOptional.orElse(null);
    }

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepo.save(experience);
    }

    @Override
    public Experience updateExperience(Long id, Experience experience) {
        Optional<Experience> existingExperienceOptional = experienceRepo.findById(id);

        if (existingExperienceOptional.isPresent()) {
            Experience existingExperience = existingExperienceOptional.get();
            // Update the existing experience with the new values
            existingExperience.setTitle(experience.getTitle());
            existingExperience.setDateDebut(experience.getDateDebut());
            existingExperience.setDateFin(experience.getDateFin());
            // Update other properties as needed

            return experienceRepo.save(existingExperience);
        }

        return null;
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepo.deleteById(id);
    }
}
