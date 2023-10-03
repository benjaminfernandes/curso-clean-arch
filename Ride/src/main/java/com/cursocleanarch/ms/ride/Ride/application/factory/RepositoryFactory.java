package com.cursocleanarch.ms.ride.Ride.application.factory;

import com.cursocleanarch.ms.ride.Ride.application.repository.DriverRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.PassengerRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;

//Abstract factory
public interface RepositoryFactory {
    PassengerRepository createPassengerRepository();
    DriverRepository createDriverRepository();
    RideRepository createRideRepository();
}
