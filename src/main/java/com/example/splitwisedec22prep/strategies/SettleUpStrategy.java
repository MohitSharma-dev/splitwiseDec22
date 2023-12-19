package com.example.splitwisedec22prep.strategies;

import com.example.splitwisedec22prep.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    public List<Expense> settleUp(List<Expense> expensesToSettleUp);
}
