package com.marcdev.rent_v3.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    String content;
    Timestamp createAt;
}
