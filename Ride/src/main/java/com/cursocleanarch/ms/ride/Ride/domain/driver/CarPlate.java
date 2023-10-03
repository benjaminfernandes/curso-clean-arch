package com.cursocleanarch.ms.ride.Ride.domain.driver;

public record CarPlate (String value) {

    public CarPlate {
        if (!this.validate(value)) throw new RuntimeException("Invalid car plate");
    }

    public boolean validate(String email) {
        return email.toLowerCase().matches("^[a-z]{3}[0-9]{4}$");
    }

    public String getValue() {
        return value;
    }
}
