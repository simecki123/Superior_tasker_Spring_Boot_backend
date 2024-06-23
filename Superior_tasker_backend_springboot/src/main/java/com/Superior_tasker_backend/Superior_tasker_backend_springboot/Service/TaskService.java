package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskListResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service for fetching tasks.
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Method for saving tasks
    public TaskModel saveTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    // Method for deleting tasks
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    // Method for getting specific task by its id
    public Optional<TaskModel> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    // Method for finding all tasks that belong to the same project
    public TaskListResponse findByProjectId(String id) {
        TaskListResponse taskListResponse = new TaskListResponse();
        taskListResponse.setTaskList(taskRepository.findByProjectId(id));
        return taskListResponse;
    }

    // Method for finding all users that belong to the same user.
    public TaskListResponse findByUserId(String id) {
        TaskListResponse taskListResponse = new TaskListResponse();
        taskListResponse.setTaskList(taskRepository.findByUserId(id));
        return taskListResponse;
    }


    // Method for updating specific task.
    public TaskModel updateTask(String id, TaskModel updatedTask) {
        Optional<TaskModel> existingTaskOptional = taskRepository.findById(id);

        if(existingTaskOptional.isPresent() ) {
            TaskModel existingTask = existingTaskOptional.get();
            existingTask.setName(updatedTask.getName());
            existingTask.setDone(updatedTask.getDone());

            return taskRepository.save(existingTask);
        } else {
            return null; // or throw an exception
        }
    }

}
