package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepo  extends JpaRepository<Formateur,Long> {
}
