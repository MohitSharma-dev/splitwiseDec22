package com.example.splitwisedec22prep.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{
    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    List<ExpenseUser> expenseUsers;
}

// Expense 1
// EU 1: A 1000 whoPaid Expense 1
// EU 2: A 500 HadtoPay Expense 1