package com.cursocleanarch.ms.ride.Ride.domain.transaction;

import java.util.UUID;

public class Transaction {
    private final UUID transactionId;
    private final double amount;
    private final String name;
    private final String email;

    public Transaction(UUID transactionId, double amount, String name, String email) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.name = name;
        this.email = email;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
