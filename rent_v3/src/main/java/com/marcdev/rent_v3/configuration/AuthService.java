package com.marcdev.rent_v3.configuration;

import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.LoginPayloadDto;
import com.marcdev.rent_v3.modelDTO.LoginResponseDto;
import com.marcdev.rent_v3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class AuthService {

    @Autowired
    UserRepository userRepository;
    public LoginResponseDto Login(LoginPayloadDto payloadDto){
        Optional<User> user = userRepository.findByUserNameOrEmail(payloadDto.getEmail(), payloadDto.getEmail());
        if (user.isPresent()){
            if (user.get().getPassWord() == payloadDto.getPassword()){
                var login = LoginResponseDto.builder()
                        .username(user.get().getUserName())
                        .accessToken("not available")
                        .build();
                return login;
            }
        }
        return null;
    }
}
