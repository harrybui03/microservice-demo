package com.example.user.controller;

import com.example.user.dto.CommentDTO;
import com.example.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("comment")
    public ResponseEntity<String> createComment(@RequestBody CommentDTO text , @RequestHeader(name="Authorization") String token) {
        return ResponseEntity.ok(userService.createComment(text, token));
    }

    @GetMapping("comment")
    public ResponseEntity<List> getAllComments(@RequestHeader(name="Authorization") String token) {
        return ResponseEntity.ok(userService.getAllComments(token));
    }
}
