package com.ruggery.bank.model;

public abstract class Account {

    private String accountNumber;
    private double balance;
    private User owner;

    protected Account(String accountNumber, double balance, User owner) {
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
    protected void setBalance(double balance){
        this.balance = balance;
    }

    //method to insert money into the account
    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //method to withdraw money
    public abstract void withdraw(double amount);

}
