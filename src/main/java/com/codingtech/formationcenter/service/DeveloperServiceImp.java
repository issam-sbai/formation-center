package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.repo.DeveloperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImp implements DeveloperService {

    private final DeveloperRepo developerRepository;

    @Autowired
    public DeveloperServiceImp(DeveloperRepo developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer getDeveloperById(Long id) {
        Optional<Developer> developerOptional = developerRepository.findById(id);
        return developerOptional.orElse(null);
    }

    @Override
    public Developer createDeveloper(Developer developer) {
        // You may add additional validation or business logic before saving
        return developerRepository.save(developer);
    }

    @Override
    public Developer updateDeveloper(Long id, Developer developer) {
        Optional<Developer> existingDeveloperOptional = developerRepository.findById(id);

        if (existingDeveloperOptional.isPresent()) {
            Developer existingDeveloper = existingDeveloperOptional.get();
            // Update the existing developer with the new values
            existingDeveloper.setDescription(developer.getDescription());
            existingDeveloper.setUrlCv(developer.getUrlCv());
            // Update other properties as needed

            return developerRepository.save(existingDeveloper);
        }

        return null;
    }

    @Override
    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }
}
