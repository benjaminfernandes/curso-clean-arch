package com.cursocleanarch.ms.ride.Ride.application.repository;

import com.cursocleanarch.ms.ride.Ride.domain.transaction.Transaction;

public interface TransactionRepository {

    void save (Transaction transaction);

}
