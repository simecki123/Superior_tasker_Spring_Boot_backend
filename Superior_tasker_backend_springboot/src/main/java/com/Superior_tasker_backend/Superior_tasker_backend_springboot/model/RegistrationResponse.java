package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

public class RegistrationResponse {
    private String message;
    private UserModel user;

    public RegistrationResponse(String message, UserModel user) {
        this.message = message;
        this.user = user;
    }

    // Getters and setters
}
