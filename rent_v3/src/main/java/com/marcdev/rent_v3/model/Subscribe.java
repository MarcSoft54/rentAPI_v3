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
@Entity(name = "subscribe")
@Table(schema = "rent")
@JsonIgnoreProperties(value = {"user"})
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Timestamp createAt;

    Long numberSubscribe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Subscribe(Long numberSubscribe) {
    }
}
