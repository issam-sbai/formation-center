package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepo  extends JpaRepository<Promotion,Long> {
}
