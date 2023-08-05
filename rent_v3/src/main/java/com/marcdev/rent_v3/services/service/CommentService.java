package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.CommentDto;
import com.marcdev.rent_v3.repository.CommentRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.CommentServiceInterface;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

public class CommentService implements CommentServiceInterface {

    CommentRepository commentRepository;
    UserRepository userRepository;
    @Override
    public boolean createComment(CommentDto commentDto, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            var comments = Comment.builder()
                    .content(commentDto.getContent())
                    .createAt(Timestamp.valueOf(LocalDateTime.now()))
                    .article(new Article())
                    .build();
            commentRepository.save(comments);
            return true;
        }
        return false;
    }

    @Override
    public Iterable<Comment> getComment() {
        return commentRepository.findAll();
    }
}
