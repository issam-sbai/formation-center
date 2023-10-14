package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Module;
import com.codingtech.formationcenter.repo.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImp implements ModuleService {

    private final ModuleRepo moduleRepo;

    @Autowired
    public ModuleServiceImp(ModuleRepo moduleRepo) {
        this.moduleRepo = moduleRepo;
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }

    @Override
    public Module getModuleById(Long id) {
        Optional<Module> moduleOptional = moduleRepo.findById(id);
        return moduleOptional.orElse(null);
    }

    @Override
    public Module createModule(Module module) {
        return moduleRepo.save(module);
    }

    @Override
    public Module updateModule(Long id, Module module) {
        Optional<Module> existingModuleOptional = moduleRepo.findById(id);

        if (existingModuleOptional.isPresent()) {
            Module existingModule = existingModuleOptional.get();
            // Update the existing module with the new values
            existingModule.setModuleName(module.getModuleName());
            // Update other properties as needed

            return moduleRepo.save(existingModule);
        }

        return null;
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepo.deleteById(id);
    }
}
