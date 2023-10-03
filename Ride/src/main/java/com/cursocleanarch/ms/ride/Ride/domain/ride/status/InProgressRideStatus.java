package com.cursocleanarch.ms.ride.Ride.domain.ride.status;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class InProgressRideStatus extends RideStatus {

    public InProgressRideStatus(Ride ride) {
        super(ride);
        this.value = Status.IN_PROGRESS;
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
        this.ride.setStatus(new CompletedRideStatus(this.ride));
    }
}
