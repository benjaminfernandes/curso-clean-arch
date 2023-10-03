package com.cursocleanarch.ms.ride.Ride.domain.fare.chain_of_responsability;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public abstract class FareCalculatorHandler {
    protected Double fare;
    protected FareCalculatorHandler next;

    public FareCalculatorHandler(FareCalculatorHandler next) {
        this.next = next;
    }

    public FareCalculatorHandler() {
    }

    public abstract Double handle(Segment segment);

    public Double calculate(Segment segment) {
        return segment.getDistance() * this.fare;
    }
}
