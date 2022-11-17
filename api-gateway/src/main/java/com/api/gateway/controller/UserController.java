package com.api.gateway.controller;

import com.api.gateway.operation.UserOperation;
import com.api.user.dto.CreateRoleDto;
import com.api.user.dto.CreateUserDto;
import com.api.user.dto.RoleDto;
import com.api.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(path = "api_gw/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    UserOperation userOperation;

    @GetMapping("/getUser")
    ResponseEntity<UserDto> getUser(@RequestParam String userName){
        return ResponseEntity.ok().body(userOperation.getUser(userName));
    }

    @GetMapping("/getUsers")
    ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok().body(userOperation.getUsers());
    }

    @PostMapping("/save")
    ResponseEntity<UserDto> saveUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        return ResponseEntity.ok().body(userOperation.saveUser(createUserDto));
    }

    @PostMapping("/role/save")
    ResponseEntity<RoleDto> saveUser(@RequestBody CreateRoleDto createRoleDto){
        return ResponseEntity.ok().body(userOperation.saveRole(createRoleDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/role/addRoleToUser/{userName}/{roleName}")
    ResponseEntity<?> addRoleToUser(@PathVariable(name = "userName") String userName, @PathVariable(name = "roleName") String roleName){
        userOperation.addRoleToUser(userName, roleName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("token/refresh")
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userOperation.refreshToken(request, response);
    }
}
