package com.cursocleanarch.ms.ride.Ride.domain.fare.chain_of_responsability;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class NormalFareCalculatorHandler extends FareCalculatorHandler{

    public NormalFareCalculatorHandler(FareCalculatorHandler next) {
        super(next);
    }

    @Override
    public Double handle(Segment segment) {
        this.fare = 2.1;

        if(!segment.isOvernight() && !segment.isSunday()){
            return this.calculate(segment);
        }

        if(this.next == null)
            throw new RuntimeException("End of chain");

        return this.next.handle(segment);
    }
}
