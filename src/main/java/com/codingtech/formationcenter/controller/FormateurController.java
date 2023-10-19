package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
public class FormateurController {

    private final FormateurService formateurService;

    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping
    public ResponseEntity<List<Formateur>> getAllFormateurs() {
        List<Formateur> formateurs = formateurService.getAllFormateurs();
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable int id) {
        Formateur formateur = formateurService.getFormateurById(id);
        if (formateur != null) {
            return new ResponseEntity<>(formateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        Formateur createdFormateur = formateurService.createFormateur(formateur);
        return new ResponseEntity<>(createdFormateur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable int id, @RequestBody Formateur formateur) {
        Formateur updatedFormateur = formateurService.updateFormateur(id, formateur);
        if (updatedFormateur != null) {
            return new ResponseEntity<>(updatedFormateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable int id) {
        formateurService.deleteFormateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
