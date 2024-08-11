package com.Superior_tasker_backend.Superior_tasker_backend_springboot.model;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.enums.UserRoleEnum;

public class RoleChangeRequest {

    private UserRoleEnum newRole;

    public UserRoleEnum getNewRole() {
        return newRole;
    }

    public void setNewRole(UserRoleEnum newRole) {
        this.newRole = newRole;
    }
}
