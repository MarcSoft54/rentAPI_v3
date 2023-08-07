package com.marcdev.rent_v3.model;

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
