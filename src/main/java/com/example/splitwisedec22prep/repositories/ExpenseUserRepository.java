package com.example.splitwisedec22prep.repositories;

import com.example.splitwisedec22prep.models.ExpenseUser;
import com.example.splitwisedec22prep.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser , Long> {

    List<ExpenseUser> findAllByUser(User user);
}
