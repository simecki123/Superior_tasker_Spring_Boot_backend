package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.AuthentificationPackage.JwtUtil;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.UserService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.LoginRequest;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.LoginResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.RegistrationResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.AuthenticationException;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Method for registering
    @PostMapping("/api/register")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody UserModel user) {
        RegistrationResponse response = userService.registerUser(user);
        if (response.getUser() == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            UserModel user = userService.getUserByEmail(loginRequest.getEmail());
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(new LoginResponse("Login successful",user, token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Invalid email or password",null, null));
        }
    }

    // Method for deleting user
    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    // Get by id
    @GetMapping("/user/findById/{id}")
    public Optional<UserModel> getUserById(@PathVariable String id) {
        return userService.getUserByID(id);
    }

    // Get by email
    @GetMapping("/user/findByEmail/{email}")
    public UserModel getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/dashboard")
    public String returnValidMessage() {
        return "Successfully login";
    }



    // Method for update
    @PutMapping("/user/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserModel updatedUser) {
        UserModel updated = userService.updateUser(id, updatedUser);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
