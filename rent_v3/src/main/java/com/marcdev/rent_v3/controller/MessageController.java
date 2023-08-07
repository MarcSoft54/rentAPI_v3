package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Message;
import com.marcdev.rent_v3.modelDTO.MessageDto;
import com.marcdev.rent_v3.services.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageService messageService;
    @PostMapping("/setMessage")
    public ResponseEntity<String> createMessage(MessageDto messageDto, Long id){
        return ResponseEntity.ok(
                messageService.createMessage(messageDto, id)
        );
    }

    @GetMapping("/getMessage")
    public ResponseEntity<List<Message>> getMesasges(Long id){
        return ResponseEntity.ok(
                messageService.getMessage(id)
        );
    }


}
