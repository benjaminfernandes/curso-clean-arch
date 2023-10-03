package com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output;

import java.util.UUID;

public class GetPassengerOutput {

    private final UUID passengerId;
    private final String name;
    private final String email;
    private final String document;

    public GetPassengerOutput(UUID passengerId, String name, String email, String document) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
        this.document = document;
    }

    public UUID getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDocument() {
        return document;
    }
}
