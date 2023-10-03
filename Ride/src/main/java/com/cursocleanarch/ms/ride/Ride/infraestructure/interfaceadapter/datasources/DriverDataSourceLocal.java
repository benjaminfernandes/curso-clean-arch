package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources;

import com.cursocleanarch.ms.ride.Ride.domain.driver.Driver;

import java.util.UUID;
//INTERFACE ADAPTER
public interface DriverDataSourceLocal extends DataSourceLocal {
    Driver save(Driver input);
    Driver get(UUID driverId);

}
