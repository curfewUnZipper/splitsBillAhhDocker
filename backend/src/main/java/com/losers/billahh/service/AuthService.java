package com.losers.billahh.service;

import com.losers.billahh.model.User;
import com.losers.billahh.repository.UserRepository;
import com.losers.billahh.security.JwtUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final JwtUtil jwt;
    private final JavaMailSender mailSender;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository repo, JwtUtil jwt, JavaMailSender mailSender){
        this.repo = repo;
        this.jwt = jwt;
        this.mailSender = mailSender;
    }

    public String login(String email, String password){
        User u = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if(!encoder.matches(password, u.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return jwt.generateToken(email);
    }

    public void changePassword(String email, String newPassword){
        User u = repo.findByEmail(email).orElseThrow();
        u.setPassword(encoder.encode(newPassword));
        repo.save(u);
    }

    public void forgotPassword(String email){
        User u = repo.findByEmail(email).orElseThrow();

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Password Reset - SplitsBillAhh");
        msg.setText("Your password is: 123 (replace logic later)");

        mailSender.send(msg);
    }
}