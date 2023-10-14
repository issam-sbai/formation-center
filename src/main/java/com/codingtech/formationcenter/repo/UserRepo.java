package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Integer> {
}
