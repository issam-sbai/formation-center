package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.entity.Module;
import com.codingtech.formationcenter.entity.Promotion;
import com.codingtech.formationcenter.service.FormateurService;
import com.codingtech.formationcenter.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
@CrossOrigin("http://localhost:5174")
public class ModuleController {

    private final ModuleService moduleService;
    private final FormateurService formateurService;


    @Autowired
    public ModuleController(ModuleService moduleService, FormateurService formateurService) {
        this.moduleService = moduleService;
        this.formateurService = formateurService;
    }

    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        List<Module> modules = moduleService.getAllModules();
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Module module = moduleService.getModuleById(id);
        if (module != null) {
            return new ResponseEntity<>(module, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        Module createdModule = moduleService.createModule(module);
        return new ResponseEntity<>(createdModule, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Module updatedModule = moduleService.updateModule(id, module);
        if (updatedModule != null) {
            return new ResponseEntity<>(updatedModule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}/assign-formateur")
    public Module assignFormateurToFormation(
            @PathVariable Long id,
            @RequestBody Formateur id_formateur
    ) {
        System.out.println(id_formateur);
        Formateur formateur =formateurService.getFormateurById(id_formateur.getId());
        return moduleService.assignFormateurToPromotion(id, formateur);
    }
}
