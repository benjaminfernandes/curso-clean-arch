package com.cursocleanarch.ms.ride.Ride.domain.fare.chain_of_responsability;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Segment;

public class OvernightSundayFareCalculatorHandler extends FareCalculatorHandler{

    public OvernightSundayFareCalculatorHandler(FareCalculatorHandler next) {
        super(next);
    }
    public OvernightSundayFareCalculatorHandler() {
    }

    @Override
    public Double handle(Segment segment) {
        this.fare = 5.0;

        if(segment.isOvernight() && segment.isSunday()){
            return this.calculate(segment);
        }

        if(this.next == null)
            throw new RuntimeException("End of chain");

        return this.next.handle(segment);
    }
}
