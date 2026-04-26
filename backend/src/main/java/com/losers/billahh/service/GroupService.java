package com.losers.billahh.service;

import com.losers.billahh.model.*;
import com.losers.billahh.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {

    private final GroupRepository groupRepo;
    private final ExpenseRepository expenseRepo;
    private final SettlementRepository settlementRepo;

    public GroupService(GroupRepository g, ExpenseRepository e, SettlementRepository s){
        this.groupRepo = g;
        this.expenseRepo = e;
        this.settlementRepo = s;
    }

    public Group create(Group g){
        g.setStatus(Group.Status.ACTIVE);
        return groupRepo.save(g);
    }

    public List<Group> all(){
        return groupRepo.findAll();
    }

    public Group update(Long id, Group g){
        Group existing = groupRepo.findById(id).orElseThrow();
        existing.setName(g.getName());
        return groupRepo.save(existing);
    }

    public Group reopen(Long id){
        Group g = groupRepo.findById(id).orElseThrow();
        g.setStatus(Group.Status.ACTIVE);
        return groupRepo.save(g);
    }

    public Map<String, Double> balance(Long groupId){

        Group g = groupRepo.findById(groupId).orElseThrow();

        double a = 0, b = 0;

        for(Expense e : expenseRepo.findByGroup(g)){
            if("A".equals(e.getPaidBy())) a += e.getAmount();
            else b += e.getAmount();
        }

        for (Settlement s : settlementRepo.findByGroup(g)) {

            if ("A".equals(s.getPaidBy())) {
                // A paid B → A loses, B gains
                a -= s.getAmount();
                b += s.getAmount();
            } else {
                // B paid A → B loses, A gains
                b -= s.getAmount();
                a += s.getAmount();
            }
        }

        double diff = a - b;

        Map<String, Double> res = new HashMap<>();
        res.put("A", diff/2);
        res.put("B", -diff/2);

        return res;
    }
}