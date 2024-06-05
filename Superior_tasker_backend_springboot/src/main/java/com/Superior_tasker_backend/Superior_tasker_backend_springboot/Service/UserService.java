package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method for saving user
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    // Method for deleting user
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    // Method for getting all users
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    // Method for getting user by email
    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Method for getting user by id
    public Optional<UserModel> getUserByID(String id) {
        return userRepository.findById(id);
    }

    // Method for updating existing user
    public UserModel updateUser(String id, UserModel updatedUser) {
        Optional<UserModel> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            UserModel existingUser = existingUserOptional.get();
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setImage(updatedUser.getImage());
            existingUser.setDescription(updatedUser.getDescription());
            existingUser.setLastName(updatedUser.getLastName());
            // Update other fields as necessary
            return userRepository.save(existingUser);
        } else {
            return null; // or throw an exception
        }
    }


}
