package com.cursocleanarch.ms.ride.Ride.application.dto.gateway;

public class InputPaymentGateway {

    private final String name;
    private final String email;
    private final double number;

    public InputPaymentGateway(String name, String email, double number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getNumber() {
        return number;
    }
}
