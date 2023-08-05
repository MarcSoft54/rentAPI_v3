package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;

import java.util.Optional;

public interface ArticleServiceInterface {

    public void createArticle(ArticleDto articleDto);

    public void deleteArticle(Long id);

    public String updateArticle(ArticleDto articleDto, Long id);

    Optional<ArticleDto> searchArticle(String keyWord, double price);

    Iterable<Article> getArticle();
}
