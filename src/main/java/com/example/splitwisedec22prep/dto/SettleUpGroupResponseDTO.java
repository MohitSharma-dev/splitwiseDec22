package com.example.splitwisedec22prep.dto;

import com.example.splitwisedec22prep.models.Expense;

import java.util.List;

public class SettleUpGroupResponseDTO {
    private ResponseType responseType;
    private List<Expense> expenses;
}

// create a separate DTO => TransactionDTO
// pay , receive , amount
// List <TransactionDTO> transaction