package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role,Long> {
}
