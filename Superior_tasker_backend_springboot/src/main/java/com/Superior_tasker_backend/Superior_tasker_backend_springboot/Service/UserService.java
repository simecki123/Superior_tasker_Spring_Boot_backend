package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.LoginRequest;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.LoginResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.RegistrationResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Service for fetching users
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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




    // Method for registering a new user
    public RegistrationResponse registerUser(UserModel user) {
        UserModel existingUser = getUserByEmail(user.getEmail());
        if (existingUser != null) {
            return new RegistrationResponse("User with this email already exists.", null);
        }

        // Encrypt the user's password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserModel registeredUser = saveUser(user);

        return new RegistrationResponse("User registered successfully.", registeredUser);
    }



}
