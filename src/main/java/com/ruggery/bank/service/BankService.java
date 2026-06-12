package com.ruggery.bank.service;

import com.ruggery.bank.model.Account;
import com.ruggery.bank.model.Transaction;

public class BankService {

    public void transfer(Account sourceAccount, Account destinationAccount, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero.");
        }

        //if amount pass the condition in withdraw
        sourceAccount.withdraw(amount);
        //It will be able to make the deposit
        destinationAccount.deposit(amount);
        //Saving the transaction receipt
        Transaction transaction = new Transaction(java.util.UUID.randomUUID().toString(), sourceAccount.getAccountNumber(), destinationAccount.getAccountNumber(), amount, java.time.LocalDateTime.now());
    }


}
