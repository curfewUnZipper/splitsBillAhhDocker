package com.losers.billahh.controller;

import com.losers.billahh.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> req){
        return service.login(req.get("email"), req.get("password"));
    }

    @PostMapping("/change-password")
    public void change(@RequestBody Map<String,String> req){
        service.changePassword(req.get("email"), req.get("newPassword"));
    }

    @PostMapping("/forgot-password")
    public void forgot(@RequestBody Map<String,String> req){
        service.forgotPassword(req.get("email"));
    }
}