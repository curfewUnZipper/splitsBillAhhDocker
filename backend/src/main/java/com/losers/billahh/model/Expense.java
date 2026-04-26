package com.losers.billahh.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Group group;

    private Double amount;
    private String paidBy;
    private String description;
    private LocalDateTime createdAt;

    public Long getId(){return id;}
    public Group getGroup(){return group;}
    public Double getAmount(){return amount;}
    public String getPaidBy(){return paidBy;}
    public String getDescription(){return description;}
    public LocalDateTime getCreatedAt(){return createdAt;}

    public void setId(Long id){this.id=id;}
    public void setGroup(Group group){this.group=group;}
    public void setAmount(Double amount){this.amount=amount;}
    public void setPaidBy(String paidBy){this.paidBy=paidBy;}
    public void setDescription(String d){this.description=d;}
    public void setCreatedAt(LocalDateTime t){this.createdAt=t;}
}