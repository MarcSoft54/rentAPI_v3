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

    @PostMapping("/{userDto}")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(
                userService.createUser(userDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                userService.deleteUser(id)
        );
    }

    @PutMapping("/{userDto}")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(
                userService.updateUser(userDto)
        );
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(
                userService.getUser()
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Iterable<User>>> search(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(
                userService.seachUser(name)
        );
    }

}
