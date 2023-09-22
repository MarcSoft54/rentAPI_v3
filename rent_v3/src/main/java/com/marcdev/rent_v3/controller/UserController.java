package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.configuration.AuthService;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.configuration.LoginResponseDto;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.configuration.LoginPayloadDto;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(
                userService.createUser(userDto)
        );
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> delUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                userService.deleteUser(id)
        );
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto,
                                             @PathVariable("id") Long id){
        return ResponseEntity.ok(
                userService.updateUser(userDto, id)
        );
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Optional<User>> getOneUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                userService.getUserBy(id)
        );
    }

    @PostMapping("/users/auth/login")
    public ResponseEntity<LoginResponseDto> authenticate (@RequestBody LoginPayloadDto loginPayloadDto){
        return ResponseEntity.ok(
                authService.Login(loginPayloadDto)
        );
    }

//    @GetMapping("/users/authorities")
//    public String authorities(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getAuthorities().toString();
//    }

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/")
    public ResponseEntity<Optional<User>> currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return  ResponseEntity.ok(
              userRepository.findByUserName(name)
        );
    }

//    @GetMapping("/users")
//    public ResponseEntity<Iterable<User>> getUsers(){
//        return ResponseEntity.ok(
//                userService.getUser()
//        );
//    }



//    @GetMapping("/users")
//    public ResponseEntity<Optional<Iterable<User>>> search(@RequestParam String name){
//        return ResponseEntity.ok(
//                userService.seachUser(name)
//        );
//    }



//    LoginResponseDto responseDto;
//
//    @GetMapping("/users/")
//    public ResponseEntity<LoginResponseDto> getCurrentUser(){
//        responseDto.setUsername("marc");
//        return ResponseEntity.ok(
//                responseDto
//        );
//    }





//    @Autowired
//    LoginPayloadDto loginPayloadDto;

//    @GetMapping("/users/login")
//    public ResponseEntity<UserLogin> getLog(@RequestParam("email") String email,
//                                            @RequestParam("password") String password){
//        loginPayloadDto.setEmail(email);
//        loginPayloadDto.setPassword(password);
//
//        return ResponseEntity.ok(
//                userService.getLogin(loginPayloadDto)
//        );
//    }
}
