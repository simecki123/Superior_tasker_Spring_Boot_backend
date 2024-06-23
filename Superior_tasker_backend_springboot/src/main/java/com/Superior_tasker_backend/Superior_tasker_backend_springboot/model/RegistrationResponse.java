package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

// Object that represents response we get from backend when user is registering.
//It may be or may not be successfully but we will either way get as response this object with different message and value for user.
public class RegistrationResponse {
    private String message;
    private UserModel user;

    public RegistrationResponse(String message, UserModel user) {
        this.message = message;
        this.user = user;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
