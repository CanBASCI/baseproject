package com.api.gateway.operation;

import com.api.user.dto.CreateRoleDto;
import com.api.user.dto.CreateUserDto;
import com.api.user.dto.RoleDto;
import com.api.user.dto.UserDto;
import com.api.user.feign.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
public class UserOperation implements UserService, UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    public UserDto getUser(String userName){
        return userService.getUser(userName);
    }
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }
    public UserDto saveUser(CreateUserDto createUserDto) throws Exception {
        createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        return userService.saveUser(createUserDto);
    }
    public RoleDto saveRole(CreateRoleDto createRoleDto){
        return userService.saveRole(createRoleDto);
    }
    public void addRoleToUser(String userName, String roleName){
        userService.addRoleToUser(userName, roleName);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.getUser(username);
        if(userDto == null)
        {
            throw new UsernameNotFoundException("User not found in database.");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userDto.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(userDto.getUserName(), userDto.getPassword(), authorities);
    }
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String userName = decodedJWT.getSubject();
                UserDto userDto = userService.getUser(userName);
                String access_token = JWT.create()
                        .withSubject(userDto.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userDto.getRoles().stream().map(RoleDto::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch(Exception ex){
                response.setHeader("error", ex.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", ex.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else{
            throw new RuntimeException("Refresh token is missing.");
        }
    }
}
