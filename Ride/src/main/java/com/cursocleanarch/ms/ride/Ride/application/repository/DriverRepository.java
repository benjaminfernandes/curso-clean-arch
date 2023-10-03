package com.cursocleanarch.ms.ride.Ride.application.repository;

import com.cursocleanarch.ms.ride.Ride.domain.driver.Driver;

import java.util.UUID;
//APPLICATION BUSINESS RULES
public interface DriverRepository {

    public Driver save(Driver driver);
    public Driver get(UUID driverId);
}
