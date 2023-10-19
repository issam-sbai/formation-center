package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Developer;
import com.codingtech.formationcenter.entity.Experience;
import com.codingtech.formationcenter.entity.Promotion;

import java.util.List;

public interface DeveloperService {

    List<Developer> getAllDevelopers();

    Developer getDeveloperById(int id);

    Developer createDeveloper(Developer developer);

    Developer updateDeveloper(int id, Developer developer);

    void deleteDeveloper(int id);


    String addexpEriencesToDeveloper(int developerName, Experience experience);

}
