package com.marcdev.rent_v3.mapperModel;

import com.marcdev.rent_v3.model.Message;
import com.marcdev.rent_v3.modelDTO.MessageDto;

public class MessageMapper {

    public MessageDto toDto(Message message){
        return new MessageDto(
                message.getContent(),
                message.getCreateTo()
        );
    }

    public Message toMessage(MessageDto messageDto){
        return new Message(
                messageDto.getContent(),
                messageDto.getCreateTo()
        );
    }

}
