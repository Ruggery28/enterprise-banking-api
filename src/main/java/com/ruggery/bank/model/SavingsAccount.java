package com.ruggery.bank.model;

import com.ruggery.bank.exception.InsufficientFundsException;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, User owner, double interestRate) {
        super(accountNumber, balance, owner);
        this.interestRate = interestRate;
    }

    //getters and setters
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            throw new InsufficientFundsException("Transaction Rejected: Insufficient savings funds.");
        }
    }
}
