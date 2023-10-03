package com.cursocleanarch.ms.ride.Ride.domain.fare.strategy;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class OvernightFareCalculator implements FareCalculator{
    private static final Double FARE = 3.9;
    @Override
    public Double calculate(Segment segment) {
        return segment.getDistance() * FARE;
    }
}
