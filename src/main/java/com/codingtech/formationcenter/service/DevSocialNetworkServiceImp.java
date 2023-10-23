 package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.DevSocialNetwork;
import com.codingtech.formationcenter.repo.DevSocialNetworkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevSocialNetworkServiceImp implements DevSocialNetworkService{

    @Autowired
    private DevSocialNetworkRepo niveauOfSkillDeveloperRepo;

    @Override
    public DevSocialNetwork saveNiveauOfSkillDeveloper(DevSocialNetwork devSocialNetwork) {
        return niveauOfSkillDeveloperRepo.save(devSocialNetwork);
    }
    @Override
    public Optional<DevSocialNetwork> getNiveauOfSkillDeveloperById(Long id) {
        return niveauOfSkillDeveloperRepo.findById(id);
    }
    @Override
    public void deleteNiveauOfSkillDeveloper(Long id) {
        niveauOfSkillDeveloperRepo.deleteById(id);
    }

    // Add other methods as needed
}
