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

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(
                userService.createUser(userDto)
        );
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                userService.deleteUser(id)
        );
    }

    @PutMapping("/users")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(
                userService.updateUser(userDto)
        );
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(
                userService.getUser()
        );
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<Optional<Iterable<User>>> search(@PathVariable("name") String name){
        return ResponseEntity.ok(
                userService.seachUser(name)
        );
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getOneUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
          userService.getUserBy(id)
        );
    }

}
