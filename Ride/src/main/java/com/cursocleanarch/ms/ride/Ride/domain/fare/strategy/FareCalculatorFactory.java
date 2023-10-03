package com.cursocleanarch.ms.ride.Ride.domain.fare.strategy;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class FareCalculatorFactory {

    public static FareCalculator create(Segment segment) {
        if (segment.isOvernight() && !segment.isSunday()) {
            return new OvernightFareCalculator();
        }
        if (segment.isOvernight() && segment.isSunday()) {
            return new OvernightSundayFareCalculator();
        }
        if (!segment.isOvernight() && segment.isSunday()) {
            return new SundayFareCalculator();
        }
        if (!segment.isOvernight() && !segment.isSunday()) {
            return new NormalFareCalculator();
        }
        throw new IllegalArgumentException("Invalid segment");
    }
}
