package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.ProjectService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectListResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    // Method to save project
    @PostMapping("/saveProject")
    public ProjectModel saveProject(@RequestBody ProjectModel projectModel) {
        return projectService.saveProject(projectModel);
    }

    // Method to delete project
    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

    // Method for getting project by its id
    @GetMapping("/getProjectById/{id}")
    public Optional<ProjectModel> getProjectById(@PathVariable String id) {
        return projectService.getProjectByID(id);
    }

    //Method for finding all projects that belong to specific user
    @GetMapping("/findAllProjects/{userId}")
    public ProjectListResponse findByUserId(@PathVariable String userId) {
        return projectService.findByUserId(userId);
    }

    // Method that serves to update specific project
    @PutMapping("/updateProject/{id}")
    public ResponseEntity<?> updateProject(@PathVariable String id, @RequestBody ProjectModel updatedProject) {
        ProjectModel updated = projectService.updateProject(id, updatedProject);
        if(updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
        }
    }
}
