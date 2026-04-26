package com.losers.billahh.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Settlement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Group group;

    private Double amount;
    private String paidBy;
    private String receivedBy;
    private LocalDateTime createdAt;

    public Long getId(){return id;}
    public Group getGroup(){return group;}
    public Double getAmount(){return amount;}
    public String getPaidBy(){return paidBy;}
    public String getReceivedBy(){return receivedBy;}

    public void setId(Long id){this.id=id;}
    public void setGroup(Group group){this.group=group;}
    public void setAmount(Double amount){this.amount=amount;}
    public void setPaidBy(String paidBy){this.paidBy=paidBy;}
    public void setReceivedBy(String r){this.receivedBy=r;}
    public void setCreatedAt(LocalDateTime t){this.createdAt=t;}
}