package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;

import java.util.Optional;

public interface ArticleServiceInterface {

    public String createArticle(ArticleDto articleDto, Long id);

    public String deleteArticle(Long id, Long userId);

    public String updateArticle(ArticleDto articleDto, Long id, Long userId);

    Optional<Iterable<Article>> searchArticleByName(String keyWord);

    Optional<Iterable<Article>> searchArticleByPrice(double price);

    Iterable<Article> getArticle();
}
