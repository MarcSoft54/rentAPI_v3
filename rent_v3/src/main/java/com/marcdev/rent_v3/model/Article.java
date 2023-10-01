package com.marcdev.rent_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@JsonIgnoreProperties(
        value = {
                "user", "ranking", "comments"
        }
)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    String typeArticle;
    @Column(nullable = false, columnDefinition = "TEXT")
    String country;
    @Column(nullable = false)
    double priceArticle;
    @Column(nullable = false, columnDefinition = "TEXT")
    String city;
    @Column(columnDefinition = "TEXT")
    String mapUrl;
    @Column(nullable = false, columnDefinition = "TEXT")
    List<String> pictureUrl;
    @Column(columnDefinition = "TEXT")
    String videoUrl;

    @Column(nullable = false, columnDefinition = "TEXT")
    String description;
//    Long parent;
    int room;
    int shower;
    int parking;
    int kitchen;
    int livingRoom;
    Timestamp createAt;
    Timestamp lastModifyAt;
    Long lastModifyBy;

    Long createBy;


    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "article",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    ) // manyToMany
    Set<Ranking> ranking;

    @OneToMany(mappedBy = "article", targetEntity = Comment.class)
    Set<Comment> comments;

    public Article(String typeArticle,
                   String country,
                   double priceArticle,
                   String city,
                   String mapUrl,
                   List<String> pictureUrl,
                   String videoUrl,
                   String description,
                   int room,
                   int shower,
                   int parking,
                   int kitchen,
                   int livingRoom) {
    }
}
