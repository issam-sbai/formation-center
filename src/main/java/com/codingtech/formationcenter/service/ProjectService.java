package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project createProject(Project project);

    Project updateProject(Long id, Project project);

    void deleteProject(Long id);
}
