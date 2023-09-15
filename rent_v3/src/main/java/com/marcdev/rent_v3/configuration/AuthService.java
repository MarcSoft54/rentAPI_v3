package com.marcdev.rent_v3.configuration;

import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    public LoginResponseDto Login(LoginPayloadDto payloadDto){
        Optional<User> user = userRepository.findByUserNameOrEmail(payloadDto.getEmail(), payloadDto.getEmail());
        if (user.isPresent()){
            if (Objects.equals(user.get().getPassWord(), payloadDto.getPassword())){
                String token = jwtService.generateToken(user.get().getEmail());
                var login = LoginResponseDto.builder()
                        .username(user.get().getUserName())
                        .accessToken(token)
                        .build();
                return login;
            }
        }
        var lok = LoginResponseDto.builder()
                .accessToken("Empty")
                .username("User not found")
                .build();
        return lok;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserNameOrEmail(username, username);
        return user.map(UserInfoDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not Found " + username));
    }
}
