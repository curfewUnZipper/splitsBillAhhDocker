package com.losers.billahh.controller;

import com.losers.billahh.model.Group;
import com.losers.billahh.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService service;

    public GroupController(GroupService service){
        this.service = service;
    }

    @GetMapping
    public List<Group> all(){
        return service.all();
    }

    @PostMapping
    public Group create(@RequestBody Group g){
        return service.create(g);
    }

    @PutMapping("/{id}")
    public Group update(@PathVariable Long id, @RequestBody Group g){
        return service.update(id,g);
    }

    @PostMapping("/{id}/reopen")
    public Group reopen(@PathVariable Long id){
        return service.reopen(id);
    }

    @GetMapping("/{id}/balance")
    public Map<String, Double> balance(@PathVariable Long id){
        return service.balance(id);
    }
}