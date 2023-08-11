package com.marcdev.rent_v3.controller;

import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.modelDTO.CommentDto;
import com.marcdev.rent_v3.services.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{userId}")
    public ResponseEntity<Boolean> createComment(@RequestParam(name = "commentDto") CommentDto commentDto,
                                                 @PathVariable(name = "userId") Long userId){
        return ResponseEntity.ok(
                commentService.createComment(commentDto, userId)
        );
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<Iterable<Comment>> getComment(@PathVariable(name = "articleId") Long articleId){
        return ResponseEntity.ok(
                commentService.getComment(articleId)
        );
    }
}
