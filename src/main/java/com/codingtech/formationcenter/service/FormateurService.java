package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Formateur;

import java.util.List;

public interface FormateurService {

    List<Formateur> getAllFormateurs();

    Formateur getFormateurById(int id);

    Formateur createFormateur(Formateur formateur);

    Formateur updateFormateur(int id, Formateur formateur);

    void deleteFormateur(int id);
}
