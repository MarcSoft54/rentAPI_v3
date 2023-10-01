package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.mapperModel.ArticleMapper;
import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.ArticleDto;
import com.marcdev.rent_v3.repository.ArticleRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.ArticleServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements ArticleServiceInterface {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public String createArticle(ArticleDto articleDto, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
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
                    .createBy(userRepository.findById(id).orElseThrow().getId())
                    .lastModifyBy(userRepository.findById(id).orElseThrow().getId())
                    .user(userRepository.getReferenceById(id))
                    .build();
            articleRepository.save(article);
            return "success";
        }
        return "not found";
    }

    @Override
    public String deleteArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()){
            articleRepository.deleteById(article.get().getId());
            return "ok";
        }
        return "Not Found";
    }

    @Override
    public String updateArticle(ArticleDto articleDto, Long id, Long userId) {
        Optional<Article> article = articleRepository.findById(id);
        Optional<User> user = userRepository.findById(userId);
        if (article.isPresent() && user.isPresent()){
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
            article.get().setLastModifyBy(userRepository.findById(userId).get().getId());
            articleRepository.save(article.get());
            return "ok";
        }
        return "not found";
    }

    @Override
    public Optional<Iterable<Article>> searchArticleByName(String keyWord) {
        return articleRepository.findByDescriptionContains(keyWord);
    }

    @Override
    public Optional<Iterable<Article>> searchArticleByPrice(double price) {
        return articleRepository.findByPriceArticleGreaterThan(price);
    }

    @Override
    public Iterable<Article> getArticle() {
        return articleRepository.findAll();
    }

}
