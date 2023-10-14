package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;

import java.util.List;

public interface DeveloperService {

    List<Developer> getAllDevelopers();

    Developer getDeveloperById(Long id);

    Developer createDeveloper(Developer developer);

    Developer updateDeveloper(Long id, Developer developer);

    void deleteDeveloper(Long id);
}
