package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo  extends JpaRepository<Project,Integer> {
}
