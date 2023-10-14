package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Promotion;

import java.util.List;

public interface PromotionService {


    Promotion savePromotion(Promotion promotion);

    Promotion updatePromotion(Long id, Promotion updatedPromotion);

    Promotion getPromotionById(Long id);

    List<Promotion> getAllPromotions();

    void deletePromotion(Long id);
}
