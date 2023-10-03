package com.cursocleanarch.ms.ride.Ride.domain.ride.status;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class CompletedRideStatus extends RideStatus{

    public CompletedRideStatus(Ride ride) {
        super(ride);
        this.value = Status.COMPLETED;
    }

    @Override
    public void request() {
        throw new IllegalArgumentException("Invalid Status");
    }

    @Override
    public void accept() {
        throw new IllegalArgumentException("Invalid Status");
    }

    @Override
    public void start() {
        throw new IllegalArgumentException("Invalid Status");
    }

    @Override
    public void end() {
        throw new IllegalArgumentException("Invalid Status");
    }
}
