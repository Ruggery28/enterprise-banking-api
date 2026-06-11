package com.ruggery.bank.model;

import com.ruggery.bank.exception.InsufficientFundsException;

public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, User owner, double overdraftLimit) {
        super(accountNumber, balance, owner); //those are variables from the account class
        this.overdraftLimit = overdraftLimit;
    }

    //Getters and setters
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (getBalance() + overdraftLimit)) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
        } else {
            throw new InsufficientFundsException("Transaction Rejected: Amount exceeds valid overdraft limit.");
        }
    }


}
