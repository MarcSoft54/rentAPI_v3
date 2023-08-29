package com.marcdev.rent_v3.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    String userName;
    String surName;
    String email;
    String passWord;
    String sex;
    int phoneNumber;
    String country;
}
