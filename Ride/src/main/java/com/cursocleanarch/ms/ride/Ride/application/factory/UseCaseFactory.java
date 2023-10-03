package com.cursocleanarch.ms.ride.Ride.application.factory;

import com.cursocleanarch.ms.ride.Ride.application.usecase.driver.CreateDriver;
import com.cursocleanarch.ms.ride.Ride.application.usecase.driver.GetDriver;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.CreatePassenger;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.GetPassenger;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.CalculateRide;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.GetRide;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.RequestRide;

public class UseCaseFactory {

    private final RepositoryFactory repositoryFactory;

    public UseCaseFactory(RepositoryFactory repositoryFactory){
        this.repositoryFactory = repositoryFactory;
    }

    public CreatePassenger createCreatePassenger() {
        return new CreatePassenger(this.repositoryFactory.createPassengerRepository());
    }

    public CreateDriver createCreateDriver() {
        return new CreateDriver(this.repositoryFactory.createDriverRepository());
    }

    public GetPassenger createGetPassenger(){
        return new GetPassenger(this.repositoryFactory.createPassengerRepository());
    }

    public GetDriver createGetDriver() {
        return new GetDriver(this.repositoryFactory.createDriverRepository());
    }

    public CalculateRide createCalculateRide() {
        return new CalculateRide();
    }

    public GetRide createGetRide(){
        return new GetRide(this.repositoryFactory);
    }

    public RequestRide createRequestRide(){
        return new RequestRide(this.repositoryFactory.createRideRepository());
    }
}
