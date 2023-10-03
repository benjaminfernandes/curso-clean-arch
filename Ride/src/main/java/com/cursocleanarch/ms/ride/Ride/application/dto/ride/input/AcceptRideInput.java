package com.cursocleanarch.ms.ride.Ride.application.dto.ride.input;

import java.time.LocalDateTime;
import java.util.UUID;

public class AcceptRideInput {

    public AcceptRideInput(UUID rideId, UUID driverId, LocalDateTime date) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.date = date;
    }

    private UUID rideId;
    private UUID driverId;
    private LocalDateTime date;

    public UUID getRideId() {
        return rideId;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
