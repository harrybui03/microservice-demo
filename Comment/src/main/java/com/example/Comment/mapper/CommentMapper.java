package com.example.Comment.mapper;

import com.example.Comment.dto.CommentDto;
import com.example.Comment.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    @Mapping(target = "text", source = "comment.text")
    @Mapping(target = "authorId", source = "comment.authorId")
    CommentDto toDto(Comment comment);

    @Mapping(target = "text", source = "commentDto.text")
    @Mapping(target = "authorId", source = "commentDto.authorId")
    Comment toEntity(CommentDto commentDto);
}
