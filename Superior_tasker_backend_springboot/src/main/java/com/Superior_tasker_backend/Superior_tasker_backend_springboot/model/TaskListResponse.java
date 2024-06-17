package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

import java.util.List;

public class TaskListResponse {

    private List<TaskModel> taskList;

    public List<TaskModel> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskModel> taskList) {
        this.taskList = taskList;
    }
}
