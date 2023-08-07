package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;
import com.marcdev.rent_v3.repository.ArticleRepository;
import com.marcdev.rent_v3.services.implement.ArticleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class ArticleService implements ArticleServiceInterface {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public String createArticle(ArticleDto articleDto) {
        var article = Article.builder()
                .typeArticle(articleDto.getTypeArticle())
                .country(articleDto.getCountry())
                .priceArticle(articleDto.getPriceArticle())
                .city(articleDto.getCity())
                .description(articleDto.getDescription())
                .kitchen(articleDto.getKitchen())
                .livingRoom(articleDto.getLivingRoom())
                .parking(articleDto.getParking())
                .pictureUrl(articleDto.getPictureUrl())
                .room(articleDto.getRoom())
                .shower(articleDto.getShower())
                .videoUrl(articleDto.getVideoUrl())
                .mapUrl(articleDto.getMapUrl())
                .createAt(Timestamp.valueOf(LocalDateTime.now()))
                .lastModifyAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        articleRepository.save(article);
        return "success";
    }

    @Override
    public String deleteArticle(Long id) {
        articleRepository.findById(id).orElseThrow();
        return "delete successfully";
    }

    @Override
    public String updateArticle(ArticleDto articleDto, Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()){
            article.get().setPriceArticle(articleDto.getPriceArticle());
            article.get().setTypeArticle(articleDto.getTypeArticle());
            article.get().setDescription(articleDto.getDescription());
            article.get().setKitchen(articleDto.getKitchen());
            article.get().setLastModifyAt(Timestamp.valueOf(LocalDateTime.now()));
            article.get().setLivingRoom(articleDto.getLivingRoom());
            article.get().setParking(articleDto.getParking());
            article.get().setPictureUrl(articleDto.getPictureUrl());
            article.get().setRoom(articleDto.getRoom());
            article.get().setVideoUrl(articleDto.getVideoUrl());
            article.get().setShower(articleDto.getShower());

            articleRepository.save(article.get());
            return "article update successfully";
        }
        return "Article not found";
    }

    @Override
    public Optional<ArticleDto> searchArticle(String keyWord, double price) {
        if(keyWord != null){
            return articleRepository.findByTypeArticleContains(keyWord);
        }
        return articleRepository.findByPriceArticleGreaterThan(price);
    }

    @Override
    public Iterable<Article> getArticle() {
        return articleRepository.findAll();
    }
}
