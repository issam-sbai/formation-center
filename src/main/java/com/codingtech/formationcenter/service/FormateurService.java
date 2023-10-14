package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Formateur;

import java.util.List;

public interface FormateurService {

    List<Formateur> getAllFormateurs();

    Formateur getFormateurById(Long id);

    Formateur createFormateur(Formateur formateur);

    Formateur updateFormateur(Long id, Formateur formateur);

    void deleteFormateur(Long id);
}
