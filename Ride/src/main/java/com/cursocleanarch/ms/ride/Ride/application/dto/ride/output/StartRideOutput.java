package com.cursocleanarch.ms.ride.Ride.application.dto.ride.output;

import java.util.UUID;

public class StartRideOutput {

    private final UUID startRideId;

    public StartRideOutput(UUID startRideId) {
        this.startRideId = startRideId;
    }

    public UUID getStartRideId() {
        return startRideId;
    }
}
