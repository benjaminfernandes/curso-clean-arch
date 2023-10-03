package com.cursocleanarch.ms.ride.Ride.application.dto.driver.input;

public class CreateDriverInput {

    private final String name;
    private final String email;
    private final String document;
    private final String carPlate;

    public CreateDriverInput(String name, String email, String document, String carPlate) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.carPlate = carPlate;
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
