package com.cursocleanarch.ms.ride.Ride.domain.person;

public record Email(String value) {
    public Email {
        if (!this.validate(value)) throw new IllegalArgumentException("Invalid email");
    }
    public boolean validate(String email) {
        return email.toLowerCase().matches("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\\\".+\\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
    }

    public String getValue() {
        return value;
    }
}
