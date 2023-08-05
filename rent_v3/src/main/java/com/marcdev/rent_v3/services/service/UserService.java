package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.*;
import com.marcdev.rent_v3.modelDTO.UserDto;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Override
    public String createUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()){
            return "not found";
        }else {
            var users = User.builder()
                    .userName(userDto.getUserName())
                    .surName(userDto.getSurName())
                    .email(userDto.getEmail())
                    .phoneNumber(userDto.getPhoneNumber())
                    .country(userDto.getCountry())
                    .sex(userDto.getSex())
                    .createAccountAt(Timestamp.valueOf(LocalDateTime.now()))
                    .comment(new Comment().getUser().getComment())
                    .article(new Article().getUser().getArticle())
                    .ranking(new Ranking().getUser().getRanking())
                    .messages(new Message().getUser().getMessages())
                    .subscribe(new Subscribe().getUser().getSubscribe())
                    .build();
            userRepository.save(users);
            return "success";
        }

    }

    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.deleteAll();
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
            return "update successfully";
        }
        return "user not found";
    }

    @Override
    public Optional<User> seachUser(String email) {
        return userRepository.findByEmail(email);
    }
}
