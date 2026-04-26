package com.losers.billahh.controller;

import java.util.List;
import java.util.Map;
import com.losers.billahh.model.Expense;
import com.losers.billahh.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service){
        this.service = service;
    }
    @GetMapping("/groups/{id}/expenses")
    public List<Map<String, Object>> getExpenses(@PathVariable Long id) {
        return service.getByGroup(id);
    }
    @PostMapping("/groups/{id}/expenses")
    public Expense add(@PathVariable Long id, @RequestBody Expense e){
        return service.add(id,e);
    }

    @DeleteMapping("/expenses/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}