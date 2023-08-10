package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.services.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscribers")
public class SubscribeController {

    @Autowired
    SubscribeService subscribeService;
    @PostMapping("/{id}/{b}")
    public ResponseEntity<Boolean> createSub(@PathVariable(name = "id") Long id,
                                             @PathVariable(name = "b") int b){
        return ResponseEntity.ok(
                subscribeService.createSubscribe(id, (long) b)
        );
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delSub(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(
                subscribeService.deleteSubscribe(id)
        );
    }

    @GetMapping("/")
    public ResponseEntity<Long> getSub(){
        return ResponseEntity.ok(
                subscribeService.getSub()
        );
    }
}
