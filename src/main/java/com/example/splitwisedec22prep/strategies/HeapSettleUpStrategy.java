package com.example.splitwisedec22prep.strategies;

import com.example.splitwisedec22prep.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettleUp) {
        // Homework : Please complete this , refer class 1 of splitwise to do this
        // create PriorityQueues
        // Going through all expenses
            // go through all expenseUser
                // finalExpense[user] += amount

        // finalExpense[user] => either of the PQs

        // while (!pq are not empty)
            // max from PQ 1 = Paid : A
            // max from PQ 2 = who had to pay : B
            // B -> A : min(max1 , max2)

        return null;
    }
}
