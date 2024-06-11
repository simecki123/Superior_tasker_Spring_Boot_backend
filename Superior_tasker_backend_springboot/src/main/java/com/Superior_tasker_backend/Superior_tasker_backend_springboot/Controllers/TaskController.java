package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.TaskService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/saveTask")
    public TaskModel saveTask(@RequestBody TaskModel taskModel) {
        return taskService.saveTask(taskModel);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/findTaskById/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/findAllTasksOfProject/{projectId}")
    public List<TaskModel> findByProjectId(@PathVariable String projectId) {
        return taskService.findByProjectId(projectId);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/findAllTasksOfUser/{userId}")
    private List<TaskModel> findByUserId(@PathVariable String userId) {
        return taskService.findByUserId(userId);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody TaskModel updatedTask) {
        TaskModel updated = taskService.updateTask(id, updatedTask);

        if(updated != null ) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
    }


}
