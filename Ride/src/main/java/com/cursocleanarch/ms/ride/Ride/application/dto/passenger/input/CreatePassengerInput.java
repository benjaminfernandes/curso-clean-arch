package com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input;

public class CreatePassengerInput {

    private final String name;
    private final String email;
    private final String document;

    public CreatePassengerInput(String name, String email, String document) {
        this.name = name;
        this.email = email;
        this.document = document;
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
