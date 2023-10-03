package com.cursocleanarch.ms.ride.Ride.domain.ride.status;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class RequestedRideStatus extends RideStatus {

    public RequestedRideStatus(Ride ride) {
        super(ride);
        this.value = Status.REQUESTED;
    }

    @Override
    public void request() {
        throw new IllegalArgumentException("Invalid Status");
    }

    @Override
    public void accept() {
        this.ride.setStatus(new AcceptedRideStatus(this.ride));
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
