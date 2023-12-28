package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.RideDataSourceLocal;

import java.util.UUID;

public class RideRepositoryImpl implements RideRepository {

    private final RideDataSourceLocal dataSourceLocal;

    public RideRepositoryImpl(RideDataSourceLocal dataSourceLocal) {
        this.dataSourceLocal = dataSourceLocal;
    }

 }
