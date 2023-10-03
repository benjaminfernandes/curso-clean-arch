package com.cursocleanarch.ms.ride.Ride.application.dto.ride.input;

import java.time.LocalDateTime;
import java.util.UUID;

public class GetRideInput {

    private final UUID rideId;
    private LocalDateTime date;

    public GetRideInput(UUID rideId, LocalDateTime date) {
        this.rideId = rideId;
        this.date = date;
    }

    public GetRideInput(UUID rideId) {
        this.rideId = rideId;
    }

    public UUID getRideId() {
        return rideId;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
