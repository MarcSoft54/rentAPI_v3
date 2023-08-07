package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.modelDTO.CommentDto;

public interface CommentServiceInterface {

    public boolean createComment(CommentDto commentDto, Long id);

    Iterable<Comment> getComment(Long id);
}
