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
    public ResponseEntity<String> createArticles(@RequestParam(name = "articleDto") ArticleDto articleDto,@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(
                articleService.createArticle(articleDto, id)
        );
    }

    @DeleteMapping("/delArticle")
    public ResponseEntity<String> delArticle(@RequestParam(name = "articleId") Long articleId){
        return ResponseEntity.ok(
                articleService.deleteArticle(articleId)
        );
    }

    @PutMapping("/updateArticle")
    public ResponseEntity<String> updateArticle(@RequestParam(name = "articleDto") ArticleDto articleDto,
                                                @RequestParam(name = "articleId") Long id,
                                                @RequestParam(name = "userId") Long userId){
        return ResponseEntity.ok(
                articleService.updateArticle(articleDto, id, userId)
        );
    }

    @GetMapping("/searchArticle")
    public ResponseEntity<Optional<ArticleDto>> searchArticleBy(@RequestParam(name = "keyWord", required = false) String kw,
                                                              @RequestParam(value = "price", required = false) double price){
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
