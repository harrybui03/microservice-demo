package com.example.Comment.wrapper;

import com.example.Comment.dto.CommentDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



public class CommentWrapper {
    @JsonDeserialize(as = CommentDto.class)
    private Object payload;

    public CommentWrapper() {

    }

    public CommentWrapper(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}