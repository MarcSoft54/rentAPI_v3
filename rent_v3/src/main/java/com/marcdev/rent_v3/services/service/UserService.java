package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.*;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.modelDTO.LoginPayloadDto;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmailAndPhoneNumber(userDto.getEmail(),userDto.getPhoneNumber() );
        if(user.isPresent()){
            return "isPresent";
        }else {
            var users = User.builder()
                    .userName(userDto.getUserName())
                    .userPicture(userDto.getUserPicture())
                    .passWord(userDto.getPassWord())
                    .email(userDto.getEmail())
                    .phoneNumber(userDto.getPhoneNumber())
                    .country(userDto.getCountry())
                    .sex(userDto.getSex())
                    .role(Role.ADMIN)
                    .createAccountAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
            userRepository.save(users);
            return "ok";
        }
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.deleteById(user.get().getId());
            return "ok";
        }
       return "not found";
    }

    @Override
    public String updateUser(UserDto userDto, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().setUserName(userDto.getUserName());
            user.get().setUserPicture(userDto.getUserPicture());
            user.get().setPhoneNumber(userDto.getPhoneNumber());
            user.get().setPassWord(userDto.getPassWord());
            user.get().setEmail(userDto.getEmail());
            userRepository.save(user.get());
            return "ok";
        }
        return "not found";
    }

    @Override
    public Optional<Iterable<User>> seachUser(String name) {
        return userRepository.findByUserNameContains(name);
    }

    @Override
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserBy(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserLogin getLogin(LoginPayloadDto loginDto) {
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        if(user.isPresent()){
            if (Objects.equals(user.get().getPassWord(), loginDto.getPassword())){
                var login = UserLogin.builder()
                        .id(user.get().getId())
                        .build();
                return login;
            }
        }
        return null;
    }


}
