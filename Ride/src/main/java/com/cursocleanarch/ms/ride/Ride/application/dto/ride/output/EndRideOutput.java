package com.cursocleanarch.ms.ride.Ride.application.dto.ride.output;

import java.util.UUID;

public class EndRideOutput {

    private final UUID rideId;

    public EndRideOutput(UUID startRideId) {
        this.rideId = startRideId;
    }

    public UUID getRideId() {
        return rideId;
    }
}
