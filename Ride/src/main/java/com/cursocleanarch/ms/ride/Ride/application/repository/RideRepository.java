package com.cursocleanarch.ms.ride.Ride.application.repository;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

import java.util.UUID;

public interface RideRepository {
    void save(Ride ride);
    Ride get(UUID rideId);
    void update(Ride ride);
}
