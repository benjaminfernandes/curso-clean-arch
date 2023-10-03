package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository;

import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;
import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.RideDataSourceLocal;

import java.util.UUID;

public class RideRepositoryImpl implements RideRepository {

    private final RideDataSourceLocal dataSourceLocal;

    public RideRepositoryImpl(RideDataSourceLocal dataSourceLocal) {
        this.dataSourceLocal = dataSourceLocal;
    }

    @Override
    public void save(Ride ride) {
        this.dataSourceLocal.save(ride);
    }

    @Override
    public Ride get(UUID rideId) {
        return this.dataSourceLocal.get(rideId);
    }

    @Override
    public void update(Ride ride) {
        this.dataSourceLocal.update(ride);
    }
}
