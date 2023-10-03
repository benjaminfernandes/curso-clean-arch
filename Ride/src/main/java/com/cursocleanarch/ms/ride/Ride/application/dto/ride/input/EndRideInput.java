package com.cursocleanarch.ms.ride.Ride.application.dto.ride.input;

import java.time.LocalDateTime;
import java.util.UUID;

public class EndRideInput {

    private final UUID rideId;
    private final LocalDateTime date;

    public EndRideInput(UUID rideId, LocalDateTime date) {
        this.rideId = rideId;
        this.date = date;
    }

    public UUID getRideId() {
        return rideId;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
