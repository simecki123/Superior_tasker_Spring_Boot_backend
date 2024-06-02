package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskModel saveTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public Optional<TaskModel> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public List<TaskModel> findByProjectId(String id) {
        return taskRepository.findByProjectId(id);
    }

}
