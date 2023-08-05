package com.marcdev.rent_v3.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "message")
@Table(schema = "rent")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
