package com.ruggery.bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts") // 1. Tells Hibernate to put all subclasses into this one single 'accounts' table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 2. Names the neon label column "account_type"
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

    @Id // 3. The account number will serve as our unique primary key string
    private String accountNumber;

    private double balance;

    // 4. Connects the account to a specific row in the 'users' table
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    // 5. Mandatory empty constructor for JPA courier
    protected Account() {
    }

    public Account(String accountNumber, double balance, User owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    //Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    //protected setBalance so the child can access
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    //method to insert money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //method to withdraw money
    public abstract void withdraw(double amount);

}
