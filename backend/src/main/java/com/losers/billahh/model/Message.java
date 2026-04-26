package com.losers.billahh.model;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private boolean active;

    public Long getId(){return id;}
    public String getMessage(){return message;}
    public boolean isActive(){return active;}

    public void setId(Long id){this.id=id;}
    public void setMessage(String m){this.message=m;}
    public void setActive(boolean a){this.active=a;}
}