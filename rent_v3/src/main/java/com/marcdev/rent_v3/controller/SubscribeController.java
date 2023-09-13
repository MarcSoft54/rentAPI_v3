package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Subscribe;
import com.marcdev.rent_v3.services.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubscribeController {

    @Autowired
    SubscribeService subscribeService;
    @PostMapping("/subscribers/{userId}/{b}")
    public ResponseEntity<Boolean> createSub(@PathVariable(name = "userId") Long id,
                                             @PathVariable(name = "b") int b){
        return ResponseEntity.ok(
                subscribeService.createSubscribe(id, (long) b)
        );
    }

    @DeleteMapping("/subscribers/{userId}")
    public ResponseEntity<String> delSub(@PathVariable(name = "userId") Long id){
        return ResponseEntity.ok(
                subscribeService.deleteSubscribe(id)
        );
    }

    @GetMapping("subscribers/{userId}")
    public ResponseEntity<Optional<Subscribe>> getSub(@PathVariable(name = "userId") Long id){
        return ResponseEntity.ok(
                subscribeService.getSub(id)
        );
    }
}
