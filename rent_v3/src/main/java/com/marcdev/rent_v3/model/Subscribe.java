package com.marcdev.rent_v3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity(name = "subscribe")
@Table(schema = "rent")
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Timestamp createAt;

    Long numberSubscribe;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}
