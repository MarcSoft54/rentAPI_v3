package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Ranking;
import com.marcdev.rent_v3.modelDTO.RankingDto;
import com.marcdev.rent_v3.services.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {

    @Autowired
    RankingService rankingService;
    @PostMapping("/{id}")
    public ResponseEntity<Boolean> createLikeAndDislike(@PathVariable(name = "id") Long id,
                                                        @RequestParam(name = "rankingDto") RankingDto rankingDto){
        return ResponseEntity.ok(
                rankingService.createLikeAndDislike(id,rankingDto)
        );
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delLikeAndDislike(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(
                rankingService.deleteLikeAndDislike(id)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Ranking>> getLikes(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(
                rankingService.getRanking((long) id)
        );
    }



}
