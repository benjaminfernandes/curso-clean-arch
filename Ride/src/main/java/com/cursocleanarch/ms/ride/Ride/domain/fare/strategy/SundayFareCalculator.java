package com.cursocleanarch.ms.ride.Ride.domain.fare.strategy;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class SundayFareCalculator implements FareCalculator{
    private final double FARE = 2.9;
    @Override
    public Double calculate(Segment segment) {
        return segment.getDistance() * FARE;
    }
}
