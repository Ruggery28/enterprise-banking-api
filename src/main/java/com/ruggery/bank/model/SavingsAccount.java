package com.ruggery.bank.model;

import com.ruggery.bank.exception.InsufficientFundsException;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SAVINGS") // Tells Hibernate: "Stamp this row as SAVINGS"
public class SavingsAccount extends Account {

    private double interestRate;

    protected SavingsAccount() {} // Empty constructor for JPA

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
