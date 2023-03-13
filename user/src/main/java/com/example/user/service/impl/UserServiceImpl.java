package com.example.user.service.impl;

import com.example.user.dto.CommentDTO;
import com.example.user.sercurity.JwtTokenProvider;
import com.example.user.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RabbitTemplate rabbitTemplate;

    public UserServiceImpl(JwtTokenProvider jwtTokenProvider, RabbitTemplate rabbitTemplate) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;
    @Override
    public String createComment(CommentDTO comment, String token) {
        String jwtToken =  token.split(" ")[1].trim();
        Long authorId = jwtTokenProvider.getUserIdFromJWT(jwtToken);
        comment.setAuthorId(authorId.longValue());
        rabbitTemplate.convertAndSend(exchange, routingkey, comment);
        return "Comment created";
    }

    @Override
    public List<CommentDTO> getAllComments(String token) {
        String jwtToken =  token.split(" ")[1].trim();
        Long authorId = jwtTokenProvider.getUserIdFromJWT(jwtToken);

        return (List<CommentDTO>) rabbitTemplate.convertSendAndReceive(exchange, routingkey, authorId);
    }
}
