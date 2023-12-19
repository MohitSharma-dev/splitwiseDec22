package com.example.splitwisedec22prep.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "userGroup")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List <User> members;
    @OneToMany(mappedBy = "group")
    private List <Expense> expenses;

    @ManyToOne
    private User createdBy;
}

// Group  1 : M   Expense
