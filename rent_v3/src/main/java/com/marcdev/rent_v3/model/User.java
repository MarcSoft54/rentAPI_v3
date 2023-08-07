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
@Entity(name = "users")
@Table(schema = "rent")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    String userName;
    @Column(nullable = false, columnDefinition = "TEXT")
    String surName;
    @Column(nullable = false, columnDefinition = "TEXT", unique = true)
    String email;
    @Column(nullable = false, columnDefinition = "TEXT")
    String passWord;

    String sex;

    @Column(nullable = false, unique = true)
    int phoneNumber;

    String country;

    Role role;

    Timestamp createAccountAt;


    @OneToMany(mappedBy = "user", targetEntity = Comment.class)
    Set<Comment> comment;

    @OneToMany(mappedBy = "user")  // manyToMany
    Set<Ranking> ranking;

    @OneToMany(mappedBy = "user", targetEntity = Article.class)//article relationShip
    Set<Article> article;

    @OneToMany(mappedBy = "user", targetEntity = Subscribe.class) //subscribes
    Set<Subscribe> subscribe;

    @OneToMany(mappedBy = "user", targetEntity = Message.class)
    Set<Message> messages;

    public User(String userName, String surName, String email, String passWord, String sex, int phoneNumber, String country) {

    }
}
