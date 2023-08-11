package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.*;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.repository.ArticleRepository;
import com.marcdev.rent_v3.repository.CommentRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public String createUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()){
            return "isPresent";
        }else {
            var users = User.builder()
                    .userName(userDto.getUserName())
                    .surName(userDto.getSurName())
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
    public String updateUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getUserName());
        if (user.isPresent()){
            user.get().setUserName(userDto.getUserName());
            user.get().setSurName(userDto.getSurName());
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


}
