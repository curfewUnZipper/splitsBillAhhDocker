package com.losers.billahh.controller;

import com.losers.billahh.model.Message;
import com.losers.billahh.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository repo;

    public MessageController(MessageRepository repo){
        this.repo = repo;
    }

    @GetMapping("/random")
    public Message random(){
        List<Message> list = repo.findByActiveTrue();
        return list.get(new Random().nextInt(list.size()));
    }

    @GetMapping
    public List<Message> all(){
        return repo.findAll();
    }

    @PostMapping
    public Message add(@RequestBody Message m){
        return repo.save(m);
    }

    @PutMapping("/{id}")
    public Message update(@PathVariable Long id, @RequestBody Message m){
        m.setId(id);
        return repo.save(m);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}