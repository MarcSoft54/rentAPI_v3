package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;
import com.marcdev.rent_v3.services.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("/setArticle")
    public ResponseEntity<String> createArticles(ArticleDto articleDto){
        return ResponseEntity.ok(
                articleService.createArticle(articleDto)
        );
    }

    @DeleteMapping("/delArticle")
    public ResponseEntity<String> delArticle(Long id){
        return ResponseEntity.ok(
                articleService.deleteArticle(id)
        );
    }

    @PutMapping("/updateArticle")
    public ResponseEntity<String> updateArticle(ArticleDto articleDto, Long id){
        return ResponseEntity.ok(
                articleService.updateArticle(articleDto, id)
        );
    }

    @GetMapping("/searchArticle")
    public ResponseEntity<Optional<ArticleDto>> searchArticle(String kw, double price){
        return ResponseEntity.ok(
                articleService.searchArticle(kw, price)
        );
    }

    @GetMapping("/getAllArticle")
    public ResponseEntity<Iterable<Article>> getArticles(){
        return ResponseEntity.ok(
                articleService.getArticle()
        );
    }
}
