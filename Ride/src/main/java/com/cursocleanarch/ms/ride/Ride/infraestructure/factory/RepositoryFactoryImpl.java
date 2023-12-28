package com.cursocleanarch.ms.ride.Ride.infraestructure.factory;

import com.cursocleanarch.ms.ride.Ride.application.factory.RepositoryFactory;
import com.cursocleanarch.ms.ride.Ride.application.repository.TransactionRepository;

public class RepositoryFactoryImpl implements RepositoryFactory {

    @Override
    public TransactionRepository transactionRepository() {
        return new Trans;
    }
}
