package com.marcdev.rent_v3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "rent")
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
    String pictureUrl;
    @Column(nullable = false, columnDefinition = "TEXT")
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




    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToMany(mappedBy = "article") // manyToMany
    Set<Ranking> ranking;

    @OneToMany(mappedBy = "article", targetEntity = Comment.class)
    Set<Comment> comments;
}
