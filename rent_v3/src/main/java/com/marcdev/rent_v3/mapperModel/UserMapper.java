package com.marcdev.rent_v3.mapperModel;

import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.UserDto;

public class UserMapper {

    public UserDto toDto(User user){
        return new UserDto(
                user.getUserName(),
                user.getUserPicture(),
                user.getEmail(),
                user.getPassWord(),
                user.getSex(),
                user.getPhoneNumber(),
                user.getCountry()
        );
    }

    public User toUser(UserDto userDto){
        return new User(
                userDto.getUserName(),
                userDto.getUserPicture(),
                userDto.getEmail(),
                userDto.getPassWord(),
                userDto.getSex(),
                userDto.getPhoneNumber(),
                userDto.getCountry()
        );
    }
}
