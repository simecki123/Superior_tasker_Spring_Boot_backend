package com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<TaskModel, String> {
    // Spring automatically understands what we want to fetch, so we don't have to write logic for fetching.
    List<TaskModel> findByProjectId(String projectId);
    List<TaskModel> findByUserId(String userId);
}
