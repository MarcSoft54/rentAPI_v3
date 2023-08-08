package com.marcdev.rent_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "comment")
@Table(schema = "rent")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String content;

    Timestamp createAt;

    @ManyToOne
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

    public Comment(String content) {

    }
}
