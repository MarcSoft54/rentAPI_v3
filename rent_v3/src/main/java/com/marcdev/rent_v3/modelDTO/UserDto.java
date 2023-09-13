package com.marcdev.rent_v3.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    String userName;
    String userPicture;
    String email;
    String passWord;
    String sex;
    Long phoneNumber;
    String country;
}
