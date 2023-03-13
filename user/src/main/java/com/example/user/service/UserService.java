package com.example.user.service;


import com.example.user.dto.CommentDTO;

import java.util.List;

public interface UserService {
    public String createComment(CommentDTO text, String token);

    public List<CommentDTO> getAllComments(String token);
}
