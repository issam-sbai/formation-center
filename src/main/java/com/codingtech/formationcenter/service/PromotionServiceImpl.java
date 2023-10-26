package com.codingtech.formationcenter.service;
import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.entity.Promotion;
import com.codingtech.formationcenter.repo.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepo promotionRepository; // Assuming you have a PromotionRepository interface

    @Autowired
    public PromotionServiceImpl(PromotionRepo promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<Promotion> getAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        promotions.forEach(promotion->{
            int nbrD = promotion.getDevelopers().size();
            promotion.setNbrDeveloper(nbrD);
        });

        return promotions;
    }

    @Override
    public Promotion updatePromotion(Long id, Promotion updatedPromotion) {
        Promotion existingPromotion = getPromotionById(id);

        if (existingPromotion != null) {
            // Update the existing promotion with the data from updatedPromotion
            existingPromotion.setNom(updatedPromotion.getNom());
            existingPromotion.setDate_dube(updatedPromotion.getDate_dube());
            existingPromotion.setDate_fin(updatedPromotion.getDate_fin());
            existingPromotion.setStatus(updatedPromotion.getStatus());

            if (updatedPromotion.getFormateurs() != null) {
                List<Formateur> newFormateurs = updatedPromotion.getFormateurs();

                // Check if each new formateur exists in the existing promotion, and if not, add them
                for (Formateur newFormateur : newFormateurs) {
                    if (!existingPromotion.getFormateurs().contains(newFormateur)) {
                        existingPromotion.getFormateurs().add(newFormateur);


                    }
                }
            }

            // Save the updated promotion
            return promotionRepository.save(existingPromotion);
        } else {
            // Handle the case where the promotion doesn't exist
            return null;
        }
    }

    @Override
    public Promotion getPromotionById(Long id) {
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        return optionalPromotion.orElse(null);
    }

    @Override
    public Promotion createPromotion(Promotion promotion) {
        // You might want to perform additional validation or business logic here
        return promotionRepository.save(promotion);
    }


    @Override
    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public Promotion assignFormateurToPromotion(Long formationId, Formateur formateur) {
        // Implement the logic to assign a formateur to a formation
        Promotion promotion = null;
        Optional<Promotion> optionalFormation = promotionRepository.findById(formationId);
        if (optionalFormation.isPresent()) {
            promotion = optionalFormation.get();
            promotion.getFormateurs().add(formateur);
            return promotionRepository.save(promotion);
        }
        return promotion;
    }

    @Override
    public Promotion addParticipantsToFormation(Long promotionId, List<Developer> developers) {

        Optional<Promotion> optFormation = promotionRepository.findById(promotionId);

        if (optFormation.isPresent()) {
            Promotion promotion = optFormation.get();
            developers.forEach(p -> promotion.getDevelopers().add(p));
            return promotionRepository.save(promotion);
        } else {

            System.out.println("Promotion with id " + promotionId + " not found");
            // You can return null or handle it differently based on your application logic
            return null;
        }
    }


    @Transactional
    @Override
    public Promotion updateFormation(Promotion promotion) {
        // Use the Spring Data JPA repository to save or update the promotion
        Promotion updatedPromotion = promotionRepository.save(promotion);

        // Additional business logic can be added here if needed

        return updatedPromotion;
    }


}
