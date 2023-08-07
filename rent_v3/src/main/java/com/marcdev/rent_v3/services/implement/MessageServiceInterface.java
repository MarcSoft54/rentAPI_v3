package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Message;
import com.marcdev.rent_v3.modelDTO.MessageDto;

import java.util.List;

public interface MessageServiceInterface {

    String createMessage(MessageDto messageDto, Long id);

    List<Message> getMessage(Long id);
}
