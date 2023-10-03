package com.cursocleanarch.ms.ride.Ride.domain.ride.status;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;

public class RideStatusFactory {

    public static RideStatus create(Ride ride, Status status) {
        if(status.equals(Status.REQUESTED)) {
            return new RequestedRideStatus(ride);
        }
        if(status.equals(Status.ACCEPTED)) {
            return new AcceptedRideStatus(ride);
        }
        if(status.equals(Status.IN_PROGRESS)) {
            return new InProgressRideStatus(ride);
        }
        if(status.equals(Status.COMPLETED)) {
            return new CompletedRideStatus(ride);
        }

        throw new IllegalArgumentException("Invalid status");
    }

}
