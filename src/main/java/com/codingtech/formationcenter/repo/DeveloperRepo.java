package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRepo  extends JpaRepository<Developer,Integer> {

}
