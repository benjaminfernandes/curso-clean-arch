package com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input;

import java.util.UUID;

public class GetPassengerInput {

    private final UUID passengerId;

    public GetPassengerInput(UUID passengerId) {
        this.passengerId = passengerId;
    }

    public UUID getPassengerId() {
        return passengerId;
    }
}
