package com.ruggery.bank.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 1. Tells Hibernate to make a table for this class
@Table(name = "transactions") // 2. Name the table 'transactions'
public class Transaction {

    @Id // 3. The unique UUID string will act as our primary key identifier
    private String id;

    @Column(nullable = false)
    private String sourceAccountNumber;

    @Column(nullable = false)
    private String destinationAccountNumber;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // 4. Mandatory empty constructor for the JPA courier
    protected Transaction() {}

    // Keep your existing full constructor here:
    public Transaction(String id, String sourceAccountNumber, String destinationAccountNumber, double amount, LocalDateTime timestamp) {
        this.id = id;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionID() {
        return id;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
