package com.losers.billahh.service;

import java.util.List;
import java.util.Map;

import com.losers.billahh.model.*;
import com.losers.billahh.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;
    private final GroupRepository groupRepo;

    public ExpenseService(ExpenseRepository r, GroupRepository g){
        this.repo = r;
        this.groupRepo = g;
    }

    public Expense add(Long groupId, Expense e){
        Group g = groupRepo.findById(groupId).orElseThrow();
        e.setGroup(g);
        e.setCreatedAt(LocalDateTime.now());
        return repo.save(e);
    }
    public List<Map<String, Object>> getByGroup(Long groupId){

        Group g = groupRepo.findById(groupId).orElseThrow();

        List<Expense> list = repo.findByGroup(g);

        List<Map<String, Object>> res = new ArrayList<>();

        for(Expense e : list){
            Map<String, Object> m = new HashMap<>();
            m.put("amount", e.getAmount());
            m.put("paidBy", e.getPaidBy());
            m.put("description", e.getDescription());
            m.put("createdAt", e.getCreatedAt());
            res.add(m);
        }

        return res;
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}