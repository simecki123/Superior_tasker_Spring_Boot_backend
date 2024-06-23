package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.TaskService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskListResponse;
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

    // Method to save task
    @PostMapping("/saveTask")
    public TaskModel saveTask(@RequestBody TaskModel taskModel) {
        return taskService.saveTask(taskModel);
    }

    // Method for deleting task by its id
    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    // Method for finding task by its id
    @GetMapping("/findTaskById/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    // Method for finding all tasks that belong to specific project
    @GetMapping("/findAllTasksOfProject/{projectId}")
    public TaskListResponse findByProjectId(@PathVariable String projectId) {
        return taskService.findByProjectId(projectId);
    }

    // Method for finding all tasks that belong to specific user
    @GetMapping("/findAllTasksOfUser/{userId}")
    private TaskListResponse findByUserId(@PathVariable String userId) {
        return taskService.findByUserId(userId);
    }

    // Method for updating specific task
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
