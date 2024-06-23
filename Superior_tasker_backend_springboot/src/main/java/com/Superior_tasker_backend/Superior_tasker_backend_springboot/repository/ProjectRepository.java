package com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
    // Spring automatically understands what we want to fetch, so we don't have to write logic for fetching.
    List<ProjectModel> findByUserId(String userId);
}
