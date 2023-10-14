package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Promotion;
import com.codingtech.formationcenter.repo.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromotionServiceImp implements PromotionService {

    private final PromotionRepo promotionRepo;

    @Autowired
    public PromotionServiceImp(PromotionRepo promotionRepo) {
        this.promotionRepo = promotionRepo;
    }

    @Override
    public Promotion savePromotion(Promotion promotion) {
        return promotionRepo.save(promotion);
    }




    @Override
    public Promotion updatePromotion(Long id, Promotion updatedPromotion) {
        Promotion existingPromotion = promotionRepo.findById(id).orElse(null);

        if (existingPromotion != null) {
            // Update the properties of the existing promotion with the new values
            existingPromotion.setNom(updatedPromotion.getNom());
            existingPromotion.setDate_dube(updatedPromotion.getDate_dube());
            existingPromotion.setDate_fin(updatedPromotion.getDate_fin());

            // Save the updated promotion
            return promotionRepo.save(existingPromotion);
        }

        return null;
    }


    @Override
    public Promotion getPromotionById(Long id) {
        return promotionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepo.findAll();
    }


    @Override
    public void deletePromotion(Long id) {
        promotionRepo.deleteById(id);
    }
}
