package com.api.user.controller;

import com.api.user.dto.CreateRoleDto;
import com.api.user.dto.CreateUserDto;
import com.api.user.dto.RoleDto;
import com.api.user.dto.UserDto;
import com.api.user.feign.UserService;
import com.api.user.operation.UserOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController implements UserService {
    @Autowired
    UserOperation userOperation;

    @Override
    public UserDto saveUser(CreateUserDto createUserDto) throws Exception {
        return userOperation.saveUser(createUserDto);
    }

    @Override
    public RoleDto saveRole(CreateRoleDto createRoleDto) {
        return userOperation.saveRole(createRoleDto);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        userOperation.addRoleToUser(userName, roleName);
    }

    @Override
    public UserDto getUser(String userName) {
        return userOperation.getUser(userName);
    }

    @Override
    public List<UserDto> getUsers() {
        return userOperation.getUsers();
    }

    @Override
    public int getPort() {
        return userOperation.getPort();
    }
}
