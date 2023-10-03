package com.cursocleanarch.ms.ride.Ride.application.dto.driver.input;

import java.util.UUID;

public class GetDriverInput  {

    private final UUID driverId;

    public GetDriverInput(UUID driverId) {
        this.driverId = driverId;
    }

    public UUID getDriverId() {
        return driverId;
    }
}
