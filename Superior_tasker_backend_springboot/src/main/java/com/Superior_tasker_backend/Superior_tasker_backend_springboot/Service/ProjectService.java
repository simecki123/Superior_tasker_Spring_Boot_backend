package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectListResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Service for fetching projects
@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    // Method for saving new project.
    public ProjectModel saveProject(ProjectModel project) {
        return projectRepository.save(project);
    }

    // Method for deleting specific project.
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    // Method for getting specific project by its id.
    public Optional<ProjectModel> getProjectByID(String id) {
        return projectRepository.findById(id);
    }

    // Method for finding all Projects that belong to specific user.
    public ProjectListResponse findByUserId(String userId) {
        List<ProjectModel> projectList = projectRepository.findByUserId(userId);
        ProjectListResponse projectListResponse = new ProjectListResponse();
        projectListResponse.setProjectList(projectList);
        return projectListResponse;
    }

    // Method for updating specific project.
    public ProjectModel updateProject(String id, ProjectModel updatedProject) {
        Optional<ProjectModel> existingProjectOptional = projectRepository.findById(id);
        if(existingProjectOptional.isPresent()) {
            ProjectModel existingProject = existingProjectOptional.get();
            existingProject.setTitle(updatedProject.getTitle());
            existingProject.setDescription(updatedProject.getDescription());
            existingProject.setCompletion(updatedProject.getCompletion());
            existingProject.setDate(updatedProject.getDate());

            return projectRepository.save(existingProject);
        } else {
            return null; // or throw an exception
        }
    }


}
