package com.marcdev.rent_v3.mapperModel;

import com.marcdev.rent_v3.model.Comment;
import com.marcdev.rent_v3.modelDTO.CommentDto;

public class CommentMapper {

    public Comment toComment(CommentDto commentDto){
        return new Comment(
                commentDto.getContent()
        );
    }

    public CommentDto toDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getContent()
        );
    }
}
