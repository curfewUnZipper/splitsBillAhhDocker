package com.losers.billahh.util;

import com.losers.billahh.model.User;
import com.losers.billahh.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public DataLoader(UserRepository repo){
        this.repo = repo;
    }

    public void run(String... args){
        if(repo.count()==0){
            repo.save(new User(null,"A","a@mail.com",encoder.encode("123")));
            repo.save(new User(null,"B","b@mail.com",encoder.encode("123")));
        }
    }
}