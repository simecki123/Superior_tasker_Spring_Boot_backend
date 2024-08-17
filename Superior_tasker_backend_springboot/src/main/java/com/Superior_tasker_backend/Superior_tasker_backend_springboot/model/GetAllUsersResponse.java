package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

import java.util.List;

public class GetAllUsersResponse {

    private List<UserModel> allUsers;

    public List<UserModel> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<UserModel> allUsers) {
        this.allUsers = allUsers;
    }
}
