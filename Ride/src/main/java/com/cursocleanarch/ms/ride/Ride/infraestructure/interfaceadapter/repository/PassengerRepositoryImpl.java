package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository;

import com.cursocleanarch.ms.ride.Ride.domain.passenger.Passenger;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.PassengerDataSourceLocal;

import java.util.UUID;

public class PassengerRepositoryImpl implements PassengerRepository {

    final PassengerDataSourceLocal passengerDataSourceLocal;

    public PassengerRepositoryImpl(PassengerDataSourceLocal passengerDataSourceLocal) {
        this.passengerDataSourceLocal = passengerDataSourceLocal;
    }
    @Override
    public Passenger save(Passenger passenger) {
        return this.passengerDataSourceLocal.save(passenger);
    }

    @Override
    public Passenger get(UUID passengerID) {
       return this.passengerDataSourceLocal.get(passengerID);
    }
}
