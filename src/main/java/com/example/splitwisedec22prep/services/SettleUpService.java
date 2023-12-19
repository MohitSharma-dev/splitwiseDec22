package com.example.splitwisedec22prep.services;

import com.example.splitwisedec22prep.models.Expense;
import com.example.splitwisedec22prep.models.ExpenseUser;
import com.example.splitwisedec22prep.models.Group;
import com.example.splitwisedec22prep.models.User;
import com.example.splitwisedec22prep.repositories.ExpenseRepository;
import com.example.splitwisedec22prep.repositories.ExpenseUserRepository;
import com.example.splitwisedec22prep.repositories.GroupRepository;
import com.example.splitwisedec22prep.repositories.UserRepository;
import com.example.splitwisedec22prep.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStrategy settleUpStrategy;
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    SettleUpService(
            GroupRepository groupRepository,
            ExpenseRepository expenseRepository,
            SettleUpStrategy settleUpStrategy,
            UserRepository userRepository,
            ExpenseUserRepository expenseUserRepository
        ){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
    }
    public List<Expense> settleUpUser(Long userId){
        // Get the user
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new RuntimeException("Invalid user !");
        }

        User user = userOptional.get();
        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);
        Set<Expense> expenses = new HashSet<>();
        for(ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        List<Expense> transactions =  settleUpStrategy.settleUp(expenses.stream().toList());
        // filter out the transactions for our corresponding user


        // 1. getting all the expenses related to the user
        // 2. Iterate through all the expenses to check who owns what
        // 3. generate transactions to settle up
        // 4. return transactions
        return transactions;
    }

    public List<Expense> settleUpGroup(Long groupId){

        // Get the Group using groupID
        Optional<Group>  groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException();
        }
        Group group = groupOptional.get();
        // 1. get all the expenses in the group
        List<Expense> expenses = expenseRepository.findAllByGroup(group);
        List<Expense> transactions = settleUpStrategy.settleUp(expenses);
        // 4. return transactions

        return transactions;
    }
}

// Break till 10:45 pm
