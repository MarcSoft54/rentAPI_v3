package com.marcdev.rent_v3.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    String typeArticle;
    String country;
    double priceArticle;
    String city;
    String mapUrl;
    List<String> pictureUrl;
    String videoUrl;
    String description;
    int room;
    int shower;
    int parking;
    int kitchen;
    int livingRoom;
}
