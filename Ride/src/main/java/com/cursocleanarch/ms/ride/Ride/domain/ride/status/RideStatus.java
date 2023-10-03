package com.cursocleanarch.ms.ride.Ride.domain.ride.status;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public abstract class RideStatus {
    protected Ride ride;
    protected Status value;

    public RideStatus(Ride ride) {
        this.ride = ride;
    }

    public abstract void request();
    public abstract void accept();
    public abstract void start();
    public abstract void end();

    public Status getValue() {
        return value;
    }
}
