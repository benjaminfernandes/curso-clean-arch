package com.cursocleanarch.ms.ride.Ride.application.dto.driver.output;

import java.util.UUID;

public class GetDriverOutput {

    private final UUID driverId;
    private final String name;
    private final String email;
    private final String document;
    private final String carPlate;

    public GetDriverOutput(UUID driverId, String name, String email, String document, String carPlate) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.document = document;
        this.carPlate = carPlate;
    }

    public UUID getDriverId() {
        return driverId;
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

    public String getCarPlate() {
        return carPlate;
    }
}
