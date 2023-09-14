package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.model.UserLogin;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.configuration.LoginPayloadDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserServiceInterface {

   public String createUser(UserDto userDto);

   public String deleteUser(Long id);

   public String updateUser(UserDto userDto, Long id);

   Optional<Iterable<User>> seachUser(String email);

   Iterable<User> getUser();

   Optional<User> getUserBy(Long id);

   UserLogin getLogin(LoginPayloadDto loginDto);

}
