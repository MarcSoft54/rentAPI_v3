package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/setUser")
    public ResponseEntity<String> createUser(UserDto userDto){
        return ResponseEntity.ok(
                userService.createUser(userDto)
        );
    }

    @DeleteMapping("/delUser")
    public ResponseEntity<String> delUser(UserDto userDto){
        return ResponseEntity.ok(
                userService.deleteUser(userDto)
        );
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(UserDto userDto){
        return ResponseEntity.ok(
                userService.updateUser(userDto)
        );
    }

    @GetMapping("/getUser")
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(
                userService.getUser()
        );
    }
    @GetMapping("/searchUser")
    public ResponseEntity<Optional<User>> search(String email){
        return ResponseEntity.ok(
                userService.seachUser(email)
        );
    }

}
