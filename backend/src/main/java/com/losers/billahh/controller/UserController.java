package com.losers.billahh.controller;

import com.losers.billahh.model.User;
import com.losers.billahh.repository.UserRepository;
import com.losers.billahh.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    private final UserRepository repo;
    private final JwtUtil jwt;

    public UserController(UserRepository repo, JwtUtil jwt){
        this.repo = repo;
        this.jwt = jwt;
    }

    @GetMapping("/me")
    public User me(HttpServletRequest request){

        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("No token provided");
        }

        String token = authHeader.substring(7);

        String email = jwt.extractEmail(token);

        return repo.findByEmail(email).orElseThrow();
    }
}