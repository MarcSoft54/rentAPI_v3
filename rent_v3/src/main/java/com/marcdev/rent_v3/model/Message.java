package com.marcdev.rent_v3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity(name = "message")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "rent")
@JsonIgnoreProperties(
        value = {
                "user"
        }
)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    Timestamp createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    Long createBy;

    public Message(String content) {

    }
}
