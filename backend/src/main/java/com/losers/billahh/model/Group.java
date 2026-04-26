package com.losers.billahh.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="groups")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { ACTIVE, SETTLED }

    public Long getId(){return id;}
    public String getName(){return name;}
    public LocalDate getStartDate(){return startDate;}
    public LocalDate getEndDate(){return endDate;}
    public Status getStatus(){return status;}

    public void setId(Long id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setStartDate(LocalDate s){this.startDate=s;}
    public void setEndDate(LocalDate e){this.endDate=e;}
    public void setStatus(Status status){this.status=status;}
}