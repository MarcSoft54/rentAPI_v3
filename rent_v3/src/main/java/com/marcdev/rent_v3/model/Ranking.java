package com.marcdev.rent_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ranking")
@Table(schema = "rent")
public class Ranking {

    @EmbeddedId
    UserArticleKey id;

    @Column
    Long likes;
    @Column
    Long dislike;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(
            value = {
                    "userName", "surName","email",
                    "passWord", "sex", "phoneNumber", "country",
                    "role", "createAccountAt", "comment", "ranking", "subscribe"
            }, allowSetters = true
    )
    User user;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    @JsonIgnoreProperties(
            value = {
                    "typeArticle", "country", "priceArticle", "ciy",
                    "mapUrl", "pictureUrl", "videoUrl", "description",
                    "room", "shower", "parking", "kitchen", "livingRoom",
                    "createAt", "lastModifyAt", "lastModifyBy", "createBy"
            },allowSetters = true
    )
    Article article;

    public Ranking(Long likes, Long dislike) {

    }
}

@Embeddable
@Data
class UserArticleKey implements Serializable {
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "article_id")
    private Long articleId;
}
