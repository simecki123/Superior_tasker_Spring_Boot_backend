package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.ProjectService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    @PostMapping("/project")
    public ProjectModel saveProject(@RequestBody ProjectModel projectModel) {
        return projectService.saveProject(projectModel);
    }

    @DeleteMapping
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

    @GetMapping
    public Optional<ProjectModel> getProjectById(@PathVariable String id) {
        return projectService.getProjectByID(id);
    }
}
