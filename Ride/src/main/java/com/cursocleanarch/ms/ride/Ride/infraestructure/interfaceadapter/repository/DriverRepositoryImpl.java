package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository;

import com.cursocleanarch.ms.ride.Ride.application.repository.DriverRepository;
import com.cursocleanarch.ms.ride.Ride.domain.driver.Driver;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.DriverDataSourceLocal;

import java.util.UUID;

//INTERFACE ADAPTER
public class DriverRepositoryImpl implements DriverRepository {

    final DriverDataSourceLocal driverDataSourceLocal;

    public DriverRepositoryImpl(DriverDataSourceLocal driverDataSourceLocal) {
        this.driverDataSourceLocal = driverDataSourceLocal;
    }

    @Override
    public Driver save(Driver driver) {
      return this.driverDataSourceLocal.save(driver);
    }

    @Override
    public Driver get(UUID driverId) {
        return this.driverDataSourceLocal.get(driverId);
    }
}
