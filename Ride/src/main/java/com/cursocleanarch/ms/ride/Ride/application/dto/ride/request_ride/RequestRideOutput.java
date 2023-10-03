package com.cursocleanarch.ms.ride.Ride.application.dto.ride.request_ride;

import java.util.UUID;

public class RequestRideOutput {

    private final UUID rideId;

    public RequestRideOutput(UUID rideId) {
        this.rideId = rideId;
    }

    public UUID getRideId() {
        return rideId;
    }
}
