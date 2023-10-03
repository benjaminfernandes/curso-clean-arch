package com.cursocleanarch.ms.ride.Ride.application.usecase.ride;

import com.cursocleanarch.ms.ride.Ride.application.dto.ride.request_ride.RequestRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.request_ride.RequestRideOutput;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;
import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;
import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class RequestRide implements UseCase<RequestRideInput, RequestRideOutput> {

    private final RideRepository rideRepository;

    public RequestRide(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public RequestRideOutput execute(RequestRideInput input) {
        var ride = Ride.create(input.getPassengerId(), new Coord(input.getFrom().getLatitude(), input.getFrom().getLongitude()),
                new Coord(input.getTo().getLatitude(), input.getTo().getLongitude()));
        this.rideRepository.save(ride);
        return new RequestRideOutput(ride.getRideId());
    }
}
