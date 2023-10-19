package com.codingtech.formationcenter.service;


import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.entity.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {
    List<Promotion> getAllPromotions();

    Promotion getPromotionById(Long id);

    Promotion createPromotion(Promotion project);


    void deletePromotion(Long id);

    Promotion assignFormateurToPromotion(Long id, Formateur formateur);

    Promotion addParticipantsToFormation(Long formationId, List<Developer> developers);
}
