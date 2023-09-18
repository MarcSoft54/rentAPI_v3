package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.configuration.AuthService;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.model.UserLogin;
import com.marcdev.rent_v3.configuration.LoginResponseDto;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.configuration.LoginPayloadDto;
import com.marcdev.rent_v3.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto){
        return  userService.createUser(userDto);
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('Role_ADMIN')")
    public String delUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@RequestBody UserDto userDto,
                             @PathVariable("id") Long id){
        return  userService.updateUser(userDto, id);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(
                userService.getUser()
        );
    }



//    @GetMapping("/users")
//    public ResponseEntity<Optional<Iterable<User>>> search(@RequestParam String name){
//        return ResponseEntity.ok(
//                userService.seachUser(name)
//        );
//    }

    @PostMapping("/users/auth/login")
    public ResponseEntity<LoginResponseDto> authenticate (@RequestBody LoginPayloadDto loginPayloadDto){
        return ResponseEntity.ok(
                authService.Login(loginPayloadDto)
        );
    }

    LoginResponseDto responseDto;

    @GetMapping("/users/")
    public ResponseEntity<LoginResponseDto> getCurrentUser(){
        responseDto.setUsername("marc");
        return ResponseEntity.ok(
                responseDto
        );
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getOneUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                userService.getUserBy(id)
        );
    }

    @Autowired
    LoginPayloadDto loginPayloadDto;

    @GetMapping("/users/login")
    public ResponseEntity<UserLogin> getLog(@RequestParam("email") String email,
                                            @RequestParam("password") String password){
        loginPayloadDto.setEmail(email);
        loginPayloadDto.setPassword(password);
        return ResponseEntity.ok(
                userService.getLogin(loginPayloadDto)
        );
    }
}
