package com.api.user.operation;

import com.api.user.data.RoleRepository;
import com.api.user.data.UserRepository;
import com.api.user.data.entity.RoleEntity;
import com.api.user.data.entity.UserEntity;
import com.api.user.dto.CreateRoleDto;
import com.api.user.dto.CreateUserDto;
import com.api.user.dto.RoleDto;
import com.api.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserOperation {
    @Value("${server.port}")
    private int port;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public List<UserDto> getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        userEntities.forEach(x -> {
            UserDto userDto = UserDto.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .userName(x.getUserName())
                    .password(x.getPassword())
                    .build();
            userDtoList.add(userDto);
        });

        return userDtoList;
    }
    public UserDto getUser(String userName) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        List<RoleDto> roleDtoList = new ArrayList<>();
        userEntity.getRoleEntities().forEach(x -> {
            RoleDto roleDto = RoleDto.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .build();
            roleDtoList.add(roleDto);
        });

        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .roles(roleDtoList)
                .build();
    }
    public UserDto saveUser(CreateUserDto createUserDto) throws Exception {

        UserEntity userEntity = userRepository.findByUserName(createUserDto.getUserName());
        if(userEntity != null)
            throw new Exception("Username already exist!");

        userEntity = new UserEntity();
        userEntity.setName(createUserDto.getName());
        userEntity.setUserName(createUserDto.getUserName());
        userEntity.setPassword(createUserDto.getPassword());

        UserEntity userSavedEntity = userRepository.save(userEntity);
        return UserDto.builder()
                .id(userSavedEntity.getId())
                .name(userSavedEntity.getName())
                .userName(userSavedEntity.getUserName())
                .password(userSavedEntity.getPassword())
                .build();
    }
    public RoleDto saveRole(CreateRoleDto createRoleDto) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(createRoleDto.getName());

        RoleEntity roleSavedEntity = roleRepository.save(roleEntity);
        return RoleDto.builder()
                .id(roleSavedEntity.getId())
                .name(roleSavedEntity.getName())
                .build();
    }
    public void addRoleToUser(String userName, String roleName){
        UserEntity userEntity = userRepository.findByUserName(userName);
        RoleEntity roleEntity = roleRepository.findByName(roleName);
        userEntity.getRoleEntities().add(roleEntity);
        userRepository.save(userEntity);
    }

    public int getPort(){
        return port;
    }
}
