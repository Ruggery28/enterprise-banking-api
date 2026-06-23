package com.ruggery.bank.repository;
import org.springframework.stereotype.Repository;
import com.ruggery.bank.model.Transaction;
import java.util.List;

@Repository
public class TransactionRepository {

    private final java.util.List<Transaction> transactionHistory = new java.util.ArrayList<>();

    public void save(Transaction transaction){
        transactionHistory.add(transaction);
    }

    public List<Transaction> findAll() {
        return transactionHistory;
    }
}
