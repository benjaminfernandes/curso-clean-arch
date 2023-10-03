package com.cursocleanarch.ms.ride.Ride.application.dto.ride.output;

public class CalculateRideOutput {

    private final Double price;

    public Double getPrice() {
        return price;
    }

    public CalculateRideOutput(Double price) {
        this.price = price;
    }
}
