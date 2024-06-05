package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.UserService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.LoginRequest;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.LoginResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.RegistrationResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    // Method for registering
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody UserModel user) {
        // Check if the email already exists
        UserModel existingUser = userService.getUserByEmail(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new RegistrationResponse("User with this email already exists.", null));
        }

        // Save the new user
        UserModel registeredUser = userService.saveUser(user);

        // Create and return a RegistrationResponse object
        RegistrationResponse response = new RegistrationResponse("User registered successfully.", registeredUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Method for deleting user
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    // Get by id
    @GetMapping("/findById/{id}")
    public Optional<UserModel> getUserById(@PathVariable String id) {
        return userService.getUserByID(id);
    }

    // Get by email
    @GetMapping("/findByEmail/{email}")
    public UserModel getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Method for login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        UserModel user = userService.getUserByEmail(loginRequest.getEmail());

        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(user);
        loginResponse.setMessage("Login successful");

        return ResponseEntity.ok(loginResponse);
    }

    // Method for update
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserModel updatedUser) {
        UserModel updated = userService.updateUser(id, updatedUser);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
