package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.UserDto;

import java.util.Optional;

public interface UserServiceInterface {

   public String createUser(UserDto userDto);

   public void deleteUser(UserDto userDto);

   public String updateUser(UserDto userDto);

   Optional<User> seachUser(String email);
}
