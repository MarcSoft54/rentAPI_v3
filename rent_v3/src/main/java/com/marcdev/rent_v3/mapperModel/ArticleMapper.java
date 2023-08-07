package com.marcdev.rent_v3.mapperModel;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.modelDTO.ArticleDto;

public class ArticleMapper {

    public Article toArticle(ArticleDto articleDto){
        return new Article(
                articleDto.getTypeArticle(),
                articleDto.getCountry(),
                articleDto.getPriceArticle(),
                articleDto.getCity(),
                articleDto.getMapUrl(),
                articleDto.getPictureUrl(),
                articleDto.getVideoUrl(),
                articleDto.getDescription(),
                articleDto.getRoom(),
                articleDto.getShower(),
                articleDto.getParking(),
                articleDto.getKitchen(),
                articleDto.getLivingRoom()
        );
    }

    public ArticleDto toDto(Article article){
        return new ArticleDto(
                article.getTypeArticle(),
                article.getCountry(),
                article.getPriceArticle(),
                article.getCity(),
                article.getMapUrl(),
                article.getPictureUrl(),
                article.getVideoUrl(),
                article.getDescription(),
                article.getRoom(),
                article.getShower(),
                article.getParking(),
                article.getKitchen(),
                article.getLivingRoom()
        );
    }
}
