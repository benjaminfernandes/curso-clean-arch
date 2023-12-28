package com.cursocleanarch.ms.ride.Ride.application.factory;

import com.cursocleanarch.ms.ride.Ride.application.repository.TransactionRepository;

//Abstract factory
public interface RepositoryFactory {
    public TransactionRepository transactionRepository();
}
