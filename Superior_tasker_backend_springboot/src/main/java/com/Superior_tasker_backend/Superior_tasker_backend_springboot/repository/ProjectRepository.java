package com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
}