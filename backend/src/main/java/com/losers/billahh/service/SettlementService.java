package com.losers.billahh.service;

import com.losers.billahh.model.*;
import com.losers.billahh.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SettlementService {

    private final SettlementRepository repo;
    private final GroupRepository groupRepo;

    public SettlementService(SettlementRepository r, GroupRepository g){
        this.repo = r;
        this.groupRepo = g;
    }

    public Settlement add(Long groupId, Settlement s){
        Group g = groupRepo.findById(groupId).orElseThrow();
        s.setGroup(g);
        s.setCreatedAt(LocalDateTime.now());
        return repo.save(s);
    }

    public Settlement update(Long id, Settlement s){
        Settlement existing = repo.findById(id).orElseThrow();
        existing.setAmount(s.getAmount());
        existing.setPaidBy(s.getPaidBy());
        existing.setReceivedBy(s.getReceivedBy());
        return repo.save(existing);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}