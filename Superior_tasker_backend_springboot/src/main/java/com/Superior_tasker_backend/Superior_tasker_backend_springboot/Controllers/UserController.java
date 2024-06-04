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


    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable String id) {
        return userService.getUserByID(id);
    }

    @GetMapping("/{email}")
    public UserModel getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

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
}
