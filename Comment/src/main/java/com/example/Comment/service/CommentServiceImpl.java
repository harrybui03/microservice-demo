package com.example.Comment.service;

import com.example.Comment.dto.CommentDto;
import com.example.Comment.mapper.CommentMapper;
import com.example.Comment.model.Comment;
import com.example.Comment.repository.CommentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void createComment(CommentDto commentDto) {
        Comment comment = CommentMapper.INSTANCE.toEntity(commentDto);
        commentRepository.save(comment);

    }

    @Override
    public CommentDto getComment(Long id) {
        return null;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Long Id) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public List<CommentDto> getCommentsByUserId(Long userId) {
        List<Comment> listComments = commentRepository.findAllByAuthorId(userId);
        List<CommentDto> listCommentsDto = new ArrayList<>();
        for (Comment comment : listComments) {
            listCommentsDto.add(CommentMapper.INSTANCE.toDto(comment));
        }
        return listCommentsDto;
    }
}
