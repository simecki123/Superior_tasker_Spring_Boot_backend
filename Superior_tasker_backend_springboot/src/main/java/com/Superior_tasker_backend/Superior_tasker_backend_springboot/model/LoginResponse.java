package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

public class LoginResponse {
    private UserModel user;
    private String message;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}