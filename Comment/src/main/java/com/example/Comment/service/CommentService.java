package com.example.Comment.service;

import com.example.Comment.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public void createComment(CommentDto commentDto);
    public CommentDto getComment(Long id);
    public CommentDto updateComment(CommentDto commentDto , Long Id);
    public void deleteComment(Long id);
    public List<CommentDto> getCommentsByUserId(Long userId);
}
