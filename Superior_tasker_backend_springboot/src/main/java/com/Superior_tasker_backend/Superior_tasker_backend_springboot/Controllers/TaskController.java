package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.TaskService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/saveUser")
    public TaskModel saveTask(@RequestBody TaskModel taskModel) {
        return taskService.saveTask(taskModel);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    private Optional<TaskModel> getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }
}
