package com.losers.billahh.controller;

import com.losers.billahh.model.Settlement;
import com.losers.billahh.service.SettlementService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SettlementController {

    private final SettlementService service;

    public SettlementController(SettlementService service){
        this.service = service;
    }

    @PostMapping("/groups/{id}/settle")
    public Settlement add(@PathVariable Long id, @RequestBody Settlement s){
        return service.add(id,s);
    }

    @PutMapping("/settlements/{id}")
    public Settlement update(@PathVariable Long id, @RequestBody Settlement s){
        return service.update(id,s);
    }

    @DeleteMapping("/settlements/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}