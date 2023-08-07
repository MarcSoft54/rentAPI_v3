package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.services.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubscribeController {

    @Autowired
    SubscribeService subscribeService;
    @PostMapping("/setSub")
    public ResponseEntity<Boolean> createSub(Long id, Long b){
        return ResponseEntity.ok(
                subscribeService.createSubscribe(id, b)
        );
    }

    @DeleteMapping("/detSub")
    public ResponseEntity<String> delSub(Long id){
        return ResponseEntity.ok(
                subscribeService.deleteSubscribe(id)
        );
    }

    @GetMapping("/getSub")
    public ResponseEntity<Long> getSub(){
        return ResponseEntity.ok(
                subscribeService.getSub()
        );
    }
}
