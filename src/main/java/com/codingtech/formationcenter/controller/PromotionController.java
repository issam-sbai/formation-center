package com.codingtech.formationcenter.controller;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.entity.Promotion;
import com.codingtech.formationcenter.service.FormateurService;
import com.codingtech.formationcenter.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private final PromotionService promotionService;
    private final FormateurService formateurService;

    @Autowired
    public PromotionController(PromotionService promotionService, FormateurService formateurService) {
        this.promotionService = promotionService;
        this.formateurService = formateurService;
    }


    @GetMapping
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        List<Promotion> promotions = promotionService.getAllPromotions();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable Long id) {
        Promotion promotion = promotionService.getPromotionById(id);
        if (promotion != null) {
            return new ResponseEntity<>(promotion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion createdPromotion = promotionService.createPromotion(promotion);
        return new ResponseEntity<>(createdPromotion, HttpStatus.CREATED);
    }

    @PutMapping ("/{id}/assign-formateur")
    public Promotion assignFormateurToFormation(
            @PathVariable Long id,
            @RequestBody Formateur id_formateur
    ) {
        System.out.println(id_formateur);
        Formateur formateur =formateurService.getFormateurById(id_formateur.getId());
        return promotionService.assignFormateurToPromotion(id, formateur);
    }

    @PutMapping("/{formationId}/participants")
    public ResponseEntity<Promotion> addParticipantsToFormation(
            @PathVariable Long formationId,
            @RequestBody List<Developer> participants) {
        Promotion updatedFormation = promotionService.addParticipantsToFormation(formationId, participants);

        if (updatedFormation != null) {
            return ResponseEntity.ok(updatedFormation);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}