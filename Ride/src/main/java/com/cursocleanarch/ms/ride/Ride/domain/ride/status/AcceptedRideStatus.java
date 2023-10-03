package com.cursocleanarch.ms.ride.Ride.domain.ride.status;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class AcceptedRideStatus extends RideStatus {

    public AcceptedRideStatus(Ride ride) {
        super(ride);
        this.value = Status.ACCEPTED;
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
        this.ride.setStatus(new InProgressRideStatus(this.ride));
    }

    @Override
    public void end() {
        throw new IllegalArgumentException("Invalid Status");
    }
}
