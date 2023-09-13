package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.Message;
import com.marcdev.rent_v3.modelDTO.MessageDto;
import com.marcdev.rent_v3.repository.MessageRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.MessageServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService implements MessageServiceInterface {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    @Override
    public String createMessage(MessageDto messageDto, Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()){
            var message = Message.builder()
                    .content(messageDto.getContent())
                    .createBy(user.get().getId())
                    .user(userRepository.getReferenceById(id))
                    .createAt(Timestamp.valueOf(LocalDateTime.now()))
                    .createTo(messageDto.getCreateTo())
                    .build();
            messageRepository.save(message);
            return "success";
        }
        return "fail";
    }

    @Override
    public List<Message> getMessage(Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()){
            return messageRepository.findAll();
        }
        return null;
    }
}
