package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

// Response we get when we try to log in. It may or may not be successfully but we will get same response with different message and value for user.
public class LoginResponse {
    private UserModel user;
    private String message;

    private String token;

    public LoginResponse(String message, UserModel user, String token) {
        this.message = message;
        this.user = user;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
