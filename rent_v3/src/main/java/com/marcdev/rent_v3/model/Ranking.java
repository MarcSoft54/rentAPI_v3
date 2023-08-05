package com.marcdev.rent_v3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "ranking")
@Table(schema = "rent")
public class Ranking {

    @EmbeddedId
    UserArticleKey id;

    Long likes;

    Long dislike;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    Article article;

}

@Embeddable
@Data
class UserArticleKey implements Serializable {
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "article_id")
    private Long articleId;
}
