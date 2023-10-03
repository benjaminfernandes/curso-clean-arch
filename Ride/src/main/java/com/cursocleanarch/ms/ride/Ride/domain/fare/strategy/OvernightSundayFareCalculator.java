package com.cursocleanarch.ms.ride.Ride.domain.fare.strategy;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class OvernightSundayFareCalculator implements FareCalculator{
    private static final Double FARE = 5.0;
    @Override
    public Double calculate(Segment segment) {
        return segment.getDistance() * FARE;
    }
}
