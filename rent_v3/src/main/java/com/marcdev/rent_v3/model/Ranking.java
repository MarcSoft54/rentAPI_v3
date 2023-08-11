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
@JsonIgnoreProperties(
        value = {
                "user", "article"
        }
)
public class Ranking {

    @EmbeddedId
    UserArticleKey id;

    @Column
    int likes;
    @Column
    int dislike;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    Article article;

    public Ranking(int likes, int dislike) {

    }

    @Embeddable
    @Data
    @NoArgsConstructor
    public static class UserArticleKey implements Serializable {
        @Column(name = "user_id")
        private Long userId;
        @Column(name = "article_id")
        private Long articleId;

        public UserArticleKey(Long id, Long id1) {

        }
    }
}


