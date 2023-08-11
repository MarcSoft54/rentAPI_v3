package com.marcdev.rent_v3.repository;

import com.marcdev.rent_v3.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Iterable<Article>> findByDescriptionContains(String keyWord);

    Optional<Iterable<Article>> findByPriceArticleGreaterThan(double price);

    void deleteByUserId(Long id);
}
