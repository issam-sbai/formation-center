package com.codingtech.formationcenter.service;


import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.entity.Promotion;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PromotionService {
    List<Promotion> getAllPromotions();

    Promotion getPromotionById(Long id);

    Promotion createPromotion(Promotion promotion);

    void deletePromotion(Long id);

    Promotion assignFormateurToPromotion(Long id, Formateur formateur);

    //Promotion addParticipantsToFormation(Long formationId, List<Developer> developers);

    Promotion updatePromotion(Long id, Promotion updatedPromotion);

    //ResponseEntity<String> updatePromotion(Long promotionId, List<Developer> developers);

    ResponseEntity<String> addListParticipantsToFormation(Long promotionId, List<Developer> developers);

    @Transactional
    Promotion updateFormation(Promotion promotion);
}

