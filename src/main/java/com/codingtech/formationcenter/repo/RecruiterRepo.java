package com.codingtech.formationcenter.repo;

import com.codingtech.formationcenter.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepo  extends JpaRepository<Recruiter,Long> {
}
