package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepo  extends JpaRepository<Developer,Long> {
}
