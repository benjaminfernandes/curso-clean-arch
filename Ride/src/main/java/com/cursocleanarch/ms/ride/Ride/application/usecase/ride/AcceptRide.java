package com.cursocleanarch.ms.ride.Ride.application.usecase.ride;


import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.AcceptRideInput;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;

public class AcceptRide {

    private final RideRepository rideRepository;

    public AcceptRide(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public void execute(AcceptRideInput input){
        var ride = this.rideRepository.get(input.getRideId());
        ride.accept(input.getDriverId(), input.getDate());
        this.rideRepository.update(ride);
    }
}
