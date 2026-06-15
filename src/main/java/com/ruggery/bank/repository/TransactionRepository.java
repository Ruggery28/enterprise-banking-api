package com.ruggery.bank.repository;

import com.ruggery.bank.model.Transaction;

import java.util.List;

public class TransactionRepository {

    private final java.util.List<Transaction> transactionHistory = new java.util.ArrayList<>();

    public void save(Transaction transaction){
        transactionHistory.add(transaction);
    }

    public List<Transaction> findAll() {
        return transactionHistory;
    }
}
