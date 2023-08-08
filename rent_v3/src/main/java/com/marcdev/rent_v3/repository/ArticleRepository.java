package com.marcdev.rent_v3.repository;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<ArticleDto> findByTypeArticleContains(String keyWord);

    Optional<ArticleDto> findByPriceArticleGreaterThan(double price);

    void deleteByUserId(Long id);
}
