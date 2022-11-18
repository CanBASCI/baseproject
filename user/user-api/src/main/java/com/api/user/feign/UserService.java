package com.api.user.feign;

import com.api.user.dto.CreateRoleDto;
import com.api.user.dto.CreateUserDto;
import com.api.user.dto.RoleDto;
import com.api.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "user-service",
        url = "http://localhost:8181"
)
//url = "$ {user.api.url}"
public interface UserService {
    @PostMapping("api/user/save")
    UserDto saveUser(@RequestBody CreateUserDto createUserDto) throws Exception;

    @PostMapping("api/role/save")
    RoleDto saveRole(@RequestBody CreateRoleDto createRoleDto);

    @RequestMapping(method = RequestMethod.POST, value = "api/role/addRoleToUser/{userName}/{roleName}")
    void addRoleToUser(@PathVariable(name = "userName") String userName, @PathVariable(name = "roleName") String roleName);

    @GetMapping("api/user/getUser")
    UserDto getUser(@RequestParam("userName") String userName);

    @GetMapping("api/user/getUsers")
    List<UserDto> getUsers();

    @GetMapping("api/user/port")
    int getPort();
}
