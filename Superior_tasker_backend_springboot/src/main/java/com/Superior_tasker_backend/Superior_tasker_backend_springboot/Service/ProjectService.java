package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectListResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectModel saveProject(ProjectModel project) {
        return projectRepository.save(project);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    public Optional<ProjectModel> getProjectByID(String id) {
        return projectRepository.findById(id);
    }

    public ProjectListResponse findByUserId(String userId) {
        List<ProjectModel> projectList = projectRepository.findByUserId(userId);
        ProjectListResponse projectListResponse = new ProjectListResponse();
        projectListResponse.setProjectList(projectList);
        return projectListResponse;
    }

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
