package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;
import com.marcdev.rent_v3.services.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @PostMapping("/articles")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createArticles(@RequestBody ArticleDto articleDto,
                                                 @RequestParam Long userId)
    {
        return ResponseEntity.ok(
                articleService.createArticle(articleDto, userId)
        );
    }

    @DeleteMapping("/articles/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> delArticle(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                articleService.deleteArticle(id)
        );
    }

    @PutMapping("/articles/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateArticle(@RequestBody ArticleDto articleDto,
                                                @PathVariable(name = "id") int id,
                                                @RequestParam int userId){
        return ResponseEntity.ok(
                articleService.updateArticle(articleDto, (long) id, (long) userId)
        );
    }

    @GetMapping("/articles/search")
    public ResponseEntity<Optional<Iterable<Article>>> searchArticleByName(@RequestParam(required = false, defaultValue = "") String kw, @RequestParam(defaultValue = "300") double price){
        if (kw.isEmpty()){
            return ResponseEntity.ok(
                    articleService.searchArticleByPrice(price)
            );
        }else {
            return ResponseEntity.ok(
                    articleService.searchArticleByName(kw)
            );
        }
    }


    @GetMapping("/articles")
    public ResponseEntity<Iterable<Article>> getArticles(){
        return ResponseEntity.ok(
                articleService.getArticle()
        );
    }
}
