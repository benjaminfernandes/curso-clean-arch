package com.cursocleanarch.ms.ride.Ride.application.usecase.ride;

import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.StartRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.output.StartRideOutput;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;

public class StartRide implements UseCase<StartRideInput, StartRideOutput> {

    private final RideRepository rideRepository;

    public StartRide(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public StartRideOutput execute(StartRideInput input) {
        var ride = this.rideRepository.get(input.getRideId());
        ride.start(input.getDate());
        this.rideRepository.update(ride);
        return new StartRideOutput(ride.getRideId());
    }

}
