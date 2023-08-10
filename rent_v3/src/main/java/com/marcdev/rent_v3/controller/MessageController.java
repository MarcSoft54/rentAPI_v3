package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Message;
import com.marcdev.rent_v3.modelDTO.MessageDto;
import com.marcdev.rent_v3.services.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    MessageService messageService;
    @PostMapping("/{id}")
    public ResponseEntity<String> createMessage(@RequestParam(name = "messageDto") MessageDto messageDto,
                                                @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(
                messageService.createMessage(messageDto, id)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Message>> getMesasges(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(
                messageService.getMessage(id)
        );
    }


}
