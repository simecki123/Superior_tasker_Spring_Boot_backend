package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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




}
