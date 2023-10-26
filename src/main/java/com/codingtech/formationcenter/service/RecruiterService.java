package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Recruiter;

import java.util.List;

public interface RecruiterService {
    List<Recruiter> getAllRecruiters();
    Recruiter getRecruiterById(Long id);
    Recruiter saveRecruiter(Recruiter recruiter);
    void deleteRecruiter(Long id);
}
