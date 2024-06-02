package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.ProjectService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/saveProject")
    public ProjectModel saveProject(@RequestBody ProjectModel projectModel) {
        return projectService.saveProject(projectModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

    @GetMapping("/{id}")
    public Optional<ProjectModel> getProjectById(@PathVariable String id) {
        return projectService.getProjectByID(id);
    }

    @GetMapping("/findAll/{userID}")
    public List<ProjectModel> findByUserId(@PathVariable String userId) {
        return projectService.findByUserId(userId);
    }
}
