package com.cursocleanarch.ms.ride.Ride.application.dto.driver.output;

import java.util.UUID;

public class CreateDriverOutput {

    private UUID driverId;

    public CreateDriverOutput(UUID driverId) {
        this.driverId = driverId;
    }

    public UUID getDriverId() {
        return driverId;
    }
}
