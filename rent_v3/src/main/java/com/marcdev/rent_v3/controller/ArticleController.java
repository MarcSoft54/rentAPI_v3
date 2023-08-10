package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;
import com.marcdev.rent_v3.services.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("/{id}")
    public ResponseEntity<String> createArticles(@RequestParam(name = "articleDto") ArticleDto articleDto,
                                                 @PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok(
                articleService.createArticle(articleDto,(Long) id)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delArticle(@PathVariable(name = "id") Long articleId){
        return ResponseEntity.ok(
                articleService.deleteArticle(articleId)
        );
    }

    @PutMapping("/update/{id}/{userId}")
    public ResponseEntity<String> updateArticle(@RequestParam(name = "articleDto") ArticleDto articleDto,
                                                @PathVariable(name = "articleId") Long id,
                                                @PathVariable(name = "userId") Long userId){
        return ResponseEntity.ok(
                articleService.updateArticle(articleDto, id, userId)
        );
    }

    @GetMapping("/search/{kw}/{price}")
    public ResponseEntity<Optional<ArticleDto>> searchArticleBy(@PathVariable(name = "kw", required = false) String kw,
                                                              @PathVariable(value = "price", required = false) double price){
        return ResponseEntity.ok(
                articleService.searchArticle(kw, price)
        );
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Article>> getArticles(){
        return ResponseEntity.ok(
                articleService.getArticle()
        );
    }
}
