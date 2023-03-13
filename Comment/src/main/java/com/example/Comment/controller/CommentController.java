package com.example.Comment.controller;

import com.example.Comment.dto.CommentDto;
import com.example.Comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /*
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }

     */

    @GetMapping("/{authorId}")
    public ResponseEntity<List> getCommentsByUserId(@PathVariable Long authorId) {
        return ResponseEntity.ok(commentService.getCommentsByUserId(authorId));
    }

}
