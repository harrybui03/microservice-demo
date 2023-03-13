package com.example.user.service;

import com.example.user.dto.JWTResponse;
import com.example.user.dto.LoginDTO;
import com.example.user.dto.RegisterDTO;

public interface AuthService {
    JWTResponse login(LoginDTO loginDTO);
    String register(RegisterDTO registerDTO);
}
