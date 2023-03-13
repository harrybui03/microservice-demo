package com.example.user.service.impl;

import com.example.user.dto.JWTResponse;
import com.example.user.dto.LoginDTO;
import com.example.user.dto.RegisterDTO;
import com.example.user.exception.APIRequestException;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.sercurity.CustomUserDetail;
import com.example.user.sercurity.JwtTokenProvider;
import com.example.user.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public JWTResponse login(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername()).orElseThrow(() -> new APIRequestException("User not found", HttpStatus.NOT_FOUND));

        boolean isPasswordMatch = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        if (!isPasswordMatch) {
            throw new APIRequestException("Password is not correct", HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername() , loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        return new JWTResponse(jwt);
    }

    @Override
    public String register(RegisterDTO registerDTO) {
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new APIRequestException("Username is already taken", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new APIRequestException("Email is already taken", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "User registered successfully";
    }
}

