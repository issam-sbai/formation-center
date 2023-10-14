package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepo  extends JpaRepository<Module,Integer> {
}
