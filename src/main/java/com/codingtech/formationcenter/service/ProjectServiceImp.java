package com.codingtech.formationcenter.service;

import com.codingtech.formationcenter.entity.Project;
import com.codingtech.formationcenter.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectServiceImp(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> projectOptional = projectRepo.findById(id);
        return projectOptional.orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Optional<Project> existingProjectOptional = projectRepo.findById(id);

        if (existingProjectOptional.isPresent()) {
            Project existingProject = existingProjectOptional.get();
            // Update the existing project with the new values
            existingProject.setProjectName(project.getProjectName());
            existingProject.setStartDate(project.getStartDate());
            existingProject.setEndDate(project.getEndDate());
            // Update other properties as needed

            return projectRepo.save(existingProject);
        }

        return null;
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}
