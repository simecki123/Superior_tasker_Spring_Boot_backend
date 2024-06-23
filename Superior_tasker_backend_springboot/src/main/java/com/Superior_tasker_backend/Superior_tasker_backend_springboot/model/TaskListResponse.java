package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

import java.util.List;

// This is object that represents response we get when we want to fetch more than one task. Here we store a whole list of them.
// THis way we can manipulate with response more effectively.
public class TaskListResponse {

    private List<TaskModel> taskList;

    public List<TaskModel> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskModel> taskList) {
        this.taskList = taskList;
    }
}
