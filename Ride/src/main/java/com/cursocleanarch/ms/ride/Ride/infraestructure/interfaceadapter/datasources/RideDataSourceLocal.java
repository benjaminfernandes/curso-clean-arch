package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

import java.util.UUID;

public interface RideDataSourceLocal extends DataSourceLocal {
    void save(Ride ride);
    Ride get(UUID rideId);
    void update(Ride ride);
}
