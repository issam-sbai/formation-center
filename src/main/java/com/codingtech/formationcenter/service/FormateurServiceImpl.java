package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Formateur;
import com.codingtech.formationcenter.repo.FormateurRepo;
import com.codingtech.formationcenter.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepo formateurRepo;

    @Autowired
    public FormateurServiceImpl(FormateurRepo formateurRepo) {
        this.formateurRepo = formateurRepo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
    @Override
    public List<Formateur> getAllFormateurs() {
        return formateurRepo.findAll();
    }

    @Override
    public Formateur getFormateurById(int id) {
        Optional<Formateur> formateurOptional = formateurRepo.findById(id);
        return formateurOptional.orElse(null);
    }

    @Override
    public Formateur createFormateur(Formateur formateur) {
        emailService.sendUserRegistrationEmail(formateur.getUsername(), formateur.getPassword());
        String hashedPassword = passwordEncoder.encode(formateur.getPassword());
        List<Role> roles=new ArrayList<>();
        roles.add(new Role(1,"FORMATEUR"));
        formateur.setPassword(hashedPassword);
        formateur.setRoles(roles);

        return formateurRepo.save(formateur);
    }

    @Override
    public Formateur updateFormateur(int id, Formateur formateur) {
        Optional<Formateur> existingFormateurOptional = formateurRepo.findById(id);

        if (existingFormateurOptional.isPresent()) {
            Formateur existingFormateur = existingFormateurOptional.get();
            // Update the existing formateur with the new values
            // Update other properties as needed

            return formateurRepo.save(existingFormateur);
        }

        return null;
    }

    @Override
    public void deleteFormateur(int id) {
        formateurRepo.deleteById(id);
    }
}
