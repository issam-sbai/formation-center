package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Recruiter;
import com.codingtech.formationcenter.repo.RecruiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterServiceImp implements RecruiterService {

    private final RecruiterRepo recruiterRepo;

    @Autowired
    public RecruiterServiceImp(RecruiterRepo recruiterRepo) {
        this.recruiterRepo = recruiterRepo;
    }

    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepo.findAll();
    }

    @Override
    public Recruiter getRecruiterById(Long id) {
        return recruiterRepo.findById(id).orElse(null);
    }

    @Override
    public Recruiter saveRecruiter(Recruiter recruiter) {
        return recruiterRepo.save(recruiter);
    }

    @Override
    public void deleteRecruiter(Long id) {
        recruiterRepo.deleteById(id);
    }
}
