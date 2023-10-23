package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.NiveauOfSkillDeveloper;
import com.codingtech.formationcenter.repo.NiveauOfSkillDeveloperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NiveauOfSkillDeveloperServiceImp  implements NiveauOfSkillDeveloperService {

    @Autowired
    private NiveauOfSkillDeveloperRepo niveauOfSkillDeveloperRepo;

    @Override
    public NiveauOfSkillDeveloper saveNiveauOfSkillDeveloper(NiveauOfSkillDeveloper niveauOfSkillDeveloper) {
        return niveauOfSkillDeveloperRepo.save(niveauOfSkillDeveloper);
    }
    @Override
    public Optional<NiveauOfSkillDeveloper> getNiveauOfSkillDeveloperById(Long id) {
        return niveauOfSkillDeveloperRepo.findById(id);
    }
    @Override
    public void deleteNiveauOfSkillDeveloper(Long id) {
        niveauOfSkillDeveloperRepo.deleteById(id);
    }

    // Add other methods as needed

}

