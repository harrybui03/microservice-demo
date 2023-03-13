package com.example.user.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JWTResponse {
    private String token;
    private String tokenType = "Bearer";

    public JWTResponse(String jwt) {
        this.token = jwt;
    }
}
