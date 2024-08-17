package com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<UserModel, String> {
    // Spring automatically understands what we want to fetch, so we don't have to write logic for fetching.
    UserModel findByEmail(String email);

    @Query("{ '_id': { $ne: ?0 } }")
    List<UserModel> findAllByIdNot(String id);

}
