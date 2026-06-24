package com.ruggery.bank.model;

import com.ruggery.bank.exception.InsufficientFundsException;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CHECKING") // Tells Hibernate: "Stamp this row as CHECKING"
public class CheckingAccount extends Account {

    private double overdraftLimit;

    protected CheckingAccount() {} // Empty constructor for JPA

    public CheckingAccount(String accountNumber, double balance, User owner, double overdraftLimit) {
        super(accountNumber, balance, owner);
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
