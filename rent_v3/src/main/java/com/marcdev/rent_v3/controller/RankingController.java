package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.modelDTO.RankingDto;
import com.marcdev.rent_v3.services.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RankingController {

    @Autowired
    RankingService rankingService;
    @PostMapping("/setLikeAndDislike")
    public ResponseEntity<Boolean> createLikeAndDislike(Long id, RankingDto rankingDto){
        return ResponseEntity.ok(
                rankingService.createLikeAndDislike(id,rankingDto)
        );
    }
    @DeleteMapping("/delLikeAndDislike")
    public ResponseEntity<String> delLikeAndDislike(Long id){
        return ResponseEntity.ok(
                rankingService.deleteLikeAndDislike(id)
        );
    }

    @GetMapping("/getLike")
    public ResponseEntity<Long> getLikes(Long id){
        return ResponseEntity.ok(
                rankingService.getLike(id)
        );
    }
    @GetMapping("/getDislike")
    public ResponseEntity<Long> getDislike(Long id){
        return ResponseEntity.ok(
                rankingService.getDislike(id)
        );
    }


}
