package com.Superior_tasker_backend.Superior_tasker_backend_springboot.Controllers;

import com.Superior_tasker_backend.Superior_tasker_backend_springboot.Service.UserService;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.enums.UserRoleEnum;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.GetAllUsersResponse;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.RoleChangeRequest;
import com.Superior_tasker_backend.Superior_tasker_backend_springboot.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers/{id}")
    public ResponseEntity<GetAllUsersResponse> getAllUsers(@PathVariable String id) {
        List<UserModel> users = userService.getAllUsersExcept(id);
        GetAllUsersResponse response = new GetAllUsersResponse();
        response.setAllUsers(users);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @PutMapping("/user/{id}/role")
    public ResponseEntity<String> changeUserRole(@PathVariable String id, @RequestBody RoleChangeRequest roleChangeRequest) {
        UserRoleEnum newRole = roleChangeRequest.getNewRole();
        userService.changeUserRole(id, newRole);
        return ResponseEntity.ok("User role updated successfully.");
    }
}