package com.example.Comment.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class CommentDto implements Serializable {
    @JsonProperty(value = "text")
    public String text;

    @JsonProperty(value = "authorId")
    public long authorId;

    public CommentDto() {
    }

    public CommentDto( String text, Long authorId) {
        this.text = text;
        this.authorId = authorId;
    }




    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }



}
