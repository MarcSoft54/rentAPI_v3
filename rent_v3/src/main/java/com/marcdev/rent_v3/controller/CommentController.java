package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.modelDTO.CommentDto;
import com.marcdev.rent_v3.services.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("setComment")
    public ResponseEntity<Boolean> createComment(CommentDto commentDto, Long id){
        return ResponseEntity.ok(
                commentService.createComment(commentDto, id)
        );
    }

    @GetMapping("/getComment")
    public ResponseEntity<Iterable<Comment>> getComment(){
        return ResponseEntity.ok(
                commentService.getComment()
        );
    }
}
