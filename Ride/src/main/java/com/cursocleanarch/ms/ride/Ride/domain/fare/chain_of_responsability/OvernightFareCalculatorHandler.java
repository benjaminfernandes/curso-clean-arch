package com.cursocleanarch.ms.ride.Ride.domain.fare.chain_of_responsability;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class OvernightFareCalculatorHandler extends FareCalculatorHandler{

    public OvernightFareCalculatorHandler(FareCalculatorHandler next) {
        super(next);
    }

    @Override
    public Double handle(Segment segment) {
        this.fare = 3.9;

        if(segment.isOvernight() && !segment.isSunday()){
            return this.calculate(segment);
        }

        if(this.next == null)
            throw new RuntimeException("End of chain");

        return this.next.handle(segment);
    }
}
