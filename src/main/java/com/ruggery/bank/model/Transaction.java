package com.ruggery.bank.model;
import java.time.LocalDateTime;

public class Transaction {

    //variables set as final because they are immutable.
    private final String transactionID;
    private final String sourceAccountNumber;
    private final String destinationAccountNumber;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(String transactionID, String sourceAccountNumber, String destinationAccountNumber, double amount, LocalDateTime timestamp) {
        this.transactionID = transactionID;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getTransactionID() {
        return transactionID;
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
