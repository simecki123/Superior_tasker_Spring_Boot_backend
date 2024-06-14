package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectListResponse {
    private List<ProjectModel> projectList;

    public List<ProjectModel> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectModel> projectList) {
        this.projectList = projectList;
    }
}
