package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public Optional<UserModel> getUserByID(String id) {
        return userRepository.findById(id);
    }


}
