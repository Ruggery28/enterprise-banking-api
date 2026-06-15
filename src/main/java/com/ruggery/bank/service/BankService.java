package com.ruggery.bank.service;

import com.ruggery.bank.exception.AccountNotFoundException;
import com.ruggery.bank.model.Account;
import com.ruggery.bank.model.Transaction;
import com.ruggery.bank.repository.AccountRepository;

public class BankService {

    private final AccountRepository accountRepository;

    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(String sourceAccountNumber, String destinationAccountNumber, double amount) {

        //this will search for both accounts and only get the NumberAccount
        Account sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber);
        Account destinationAccount = accountRepository.findByAccountNumber(destinationAccountNumber);

        if (sourceAccount == null) {
            throw new AccountNotFoundException("Source account has not been found.");
        }

        if (destinationAccount == null) {
            throw new AccountNotFoundException("Destination account has not been found.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero.");
        }

        //if amount pass the condition in withdraw
        sourceAccount.withdraw(amount);
        //It will be able to make the deposit
        destinationAccount.deposit(amount);
        //Saving the transaction receipt
        Transaction transaction = new Transaction(java.util.UUID.randomUUID().toString(), sourceAccount.getAccountNumber(), destinationAccount.getAccountNumber(), amount, java.time.LocalDateTime.now());

        //Save the new values into the account and update
        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);
    }


}
