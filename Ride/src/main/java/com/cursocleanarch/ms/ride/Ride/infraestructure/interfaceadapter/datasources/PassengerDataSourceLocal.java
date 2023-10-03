package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources;

import com.cursocleanarch.ms.ride.Ride.domain.passenger.Passenger;

import java.util.UUID;

public interface PassengerDataSourceLocal extends DataSourceLocal {
    Passenger save(Passenger input);
    Passenger get(UUID passengerId);
}
