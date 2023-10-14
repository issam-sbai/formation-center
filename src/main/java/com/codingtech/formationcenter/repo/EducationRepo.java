package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo  extends JpaRepository<Education,Integer> {
}
