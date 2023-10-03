package com.cursocleanarch.ms.ride.Ride.application.repository;

import com.cursocleanarch.ms.ride.Ride.domain.passenger.Passenger;

import java.util.UUID;

public interface PassengerRepository  {
   Passenger save(Passenger passenger);
    Passenger get(UUID passengerID);
}
