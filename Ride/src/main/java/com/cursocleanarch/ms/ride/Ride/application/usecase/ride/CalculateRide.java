package com.cursocleanarch.ms.ride.Ride.application.usecase.ride;

import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.CalculateRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.PositionInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.output.CalculateRideOutput;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;
import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;
import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class CalculateRide implements UseCase<CalculateRideInput, CalculateRideOutput> {
    @Override
    public CalculateRideOutput execute(CalculateRideInput input) {
        var ride = new Ride(new Coord(0l,0l), new Coord(0l,0l));
        for(PositionInput position : input.getPositions()) {
            ride.addPosition(position.getLatitude(), position.getLongitude(), position.getDate());
        }
        var price = ride.calculate();
        return new CalculateRideOutput(price);
    }
}
