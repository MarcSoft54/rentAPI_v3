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
    @PostMapping("/")
    public ResponseEntity<Boolean> createLikeAndDislike(@RequestParam("userId") Long userId,
                                                        @RequestParam("articleId") Long articleId,
                                                        @RequestBody RankingDto rankingDto){
        return ResponseEntity.ok(
                rankingService.createLikeAndDislike(userId, articleId,rankingDto)
        );
    }
    @DeleteMapping("/{userId}/{articleId}")
    public ResponseEntity<String> delLikeAndDislike(@PathVariable("userId") Long userId,
                                                    @PathVariable("articleId") Long articleId){
        return ResponseEntity.ok(
                rankingService.deleteLikeAndDislike(userId, articleId)
        );
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<List<Ranking>> getLikes(@PathVariable(name = "articleId") Long articleId){
        return ResponseEntity.ok(
                rankingService.getRanking(articleId)
        );
    }



}
