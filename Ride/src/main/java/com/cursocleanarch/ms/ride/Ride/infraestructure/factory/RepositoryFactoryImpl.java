package com.cursocleanarch.ms.ride.Ride.infraestructure.factory;

import com.cursocleanarch.ms.ride.Ride.application.factory.RepositoryFactory;
import com.cursocleanarch.ms.ride.Ride.application.repository.DriverRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.PassengerRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.DriverDataSourceLocal;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.PassengerDataSourceLocal;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.RideDataSourceLocal;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.DriverRepositoryImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.PassengerRepositoryImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.RideRepositoryImpl;

public class RepositoryFactoryImpl implements RepositoryFactory {

    private final PassengerDataSourceLocal passengerDataSourceLocal;
    private final DriverDataSourceLocal driverDataSourceLocal;
    private final RideDataSourceLocal rideDataSourceLocal;


    public RepositoryFactoryImpl(PassengerDataSourceLocal passengerDataSourceLocal, DriverDataSourceLocal driverDataSourceLocal, RideDataSourceLocal rideDataSourceLocal) {
        this.passengerDataSourceLocal = passengerDataSourceLocal;
        this.driverDataSourceLocal = driverDataSourceLocal;
        this.rideDataSourceLocal = rideDataSourceLocal;
    }

    @Override
    public PassengerRepository createPassengerRepository() {
        return new PassengerRepositoryImpl(passengerDataSourceLocal);
    }

    @Override
    public DriverRepository createDriverRepository() {
        return new DriverRepositoryImpl(driverDataSourceLocal);
    }

    @Override
    public RideRepository createRideRepository() {
        return new RideRepositoryImpl(rideDataSourceLocal);
    }
}
