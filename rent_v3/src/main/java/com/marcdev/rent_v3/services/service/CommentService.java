package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.Article;
import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.modelDTO.CommentDto;
import com.marcdev.rent_v3.repository.ArticleRepository;
import com.marcdev.rent_v3.repository.CommentRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService implements CommentServiceInterface {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;
    @Override
    public boolean createComment(CommentDto commentDto, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            var comments = Comment.builder()
                    .content(commentDto.getContent())
                    .createAt(Timestamp.valueOf(LocalDateTime.now()))
                    .user(userRepository.getReferenceById(id))
                    .article(articleRepository.getReferenceById(id))
                    .build();
            commentRepository.save(comments);
            return true;
        }
        return false;
    }

    @Override
    public Iterable<Comment> getComment(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (article.isPresent()){
            return commentRepository.findAll();
        }
        return null;
    }
}
