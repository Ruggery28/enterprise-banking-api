package com.ruggery.bank.repository;

import com.ruggery.bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// We tell JpaRepository we are managing the 'Transaction' entity, and its Primary Key is a 'String' (the UUID)
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    // It automatically inherits .save() and .findAll(), so we can leave this completely blank!
}