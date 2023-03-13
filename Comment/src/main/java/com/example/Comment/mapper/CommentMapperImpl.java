package com.example.Comment.mapper;

import com.example.Comment.dto.CommentDto;
import com.example.Comment.model.Comment;

public class CommentMapperImpl implements CommentMapper {
    @Override
    public CommentDto toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();


        commentDto.setText( comment.getText() );
        commentDto.setAuthorId( comment.getAuthorId() );

        return commentDto;
    }

    @Override
    public Comment toEntity(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( commentDto.getText() );
        comment.setAuthorId( commentDto.getAuthorId() );

        return comment;
    }
}
