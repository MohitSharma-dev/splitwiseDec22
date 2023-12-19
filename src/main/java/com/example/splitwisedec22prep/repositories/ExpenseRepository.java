package com.example.splitwisedec22prep.repositories;

import com.example.splitwisedec22prep.models.Expense;
import com.example.splitwisedec22prep.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense , Long> {
    List<Expense> findAllByGroup(Group group);
}
